import sys
from pyspark import SparkContext

if len(sys.argv)!=3: sys.exit("Usage: spark-submit p.py <input> <output>")
sc = SparkContext(appName="NonPairRDD")

rdd = sc.textFile(sys.argv[1])
extra = sc.parallelize(["grape","apple"])

print("Original RDD:", rdd.collect())
print("map (upper-case):", rdd.map(str.upper).collect())
print("filter (starts with 'a'):", rdd.filter(lambda x:x.startswith("a")).collect())
print("flatMap (split words):", rdd.flatMap(lambda x:x.split(" ")).collect())
print("distinct:", rdd.distinct().collect())
print("union:", rdd.union(extra).collect())
print("count:", rdd.count())
print("take(3):", rdd.take(3))
print("reduce (concatenate):", rdd.reduce(lambda a,b:a+","+b))

rdd.distinct().saveAsTextFile(sys.argv[2])
sc.stop()