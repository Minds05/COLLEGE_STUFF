from pyspark import SparkContext
from pyspark.streaming import StreamingContext

sc = SparkContext(appName="SocketWordCount")
sc.setLogLevel("ERROR")

ssc = StreamingContext(sc, 5)

lines = ssc.socketTextStream("127.0.0.1", 9998)
words = lines.flatMap(lambda x: x.split())
counts = words.map(lambda x: (x, 1)).reduceByKey(lambda a, b: a + b)

counts.pprint()

ssc.start()
ssc.awaitTermination()