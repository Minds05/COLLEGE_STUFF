import sys
from pyspark.sql import SparkSession

if len(sys.argv)<2: sys.exit("Usage: spark-submit p2.py <input>")
sc = SparkSession.builder.appName("AccumBC").getOrCreate().sparkContext

bc = sc.broadcast({"KA":"Bengaluru","TN":"Chennai","MH":"Mumbai","DL":"New Delhi"})
blank = sc.accumulator(0)

def f(x):
    if x.strip()=="":
        blank.add(1); return None
    return (x.strip(), bc.value.get(x.strip(),"Unknown State Code"))

print("State -> Capital:")
for i in sc.textFile(sys.argv[1]).map(f).filter(lambda x:x).collect():
    print(i)

print("Number of blank lines =", blank.value)