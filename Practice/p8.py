import sys
from pyspark import SparkContext

if len(sys.argv)!=3: sys.exit("Usage: spark-submit p2.py <input> <output>")
sc = SparkContext(appName="PairRDD")

rdd = (sc.textFile(sys.argv[1])
       .map(lambda x:x.split())
       .filter(lambda x: len(x)==2)
       .map(lambda x:(x[0], int(x[1]))))

print("Original Pair RDD:", rdd.collect())
print("reduceByKey:", rdd.reduceByKey(lambda a,b:a+b).collect())

rdd.reduceByKey(lambda a,b:a+b).saveAsTextFile(sys.argv[2])
sc.stop()