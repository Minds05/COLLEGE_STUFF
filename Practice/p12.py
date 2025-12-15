from pyspark.sql import SparkSession
from pyspark.ml import Pipeline
from pyspark.ml.feature import VectorAssembler
from pyspark.ml.classification import LogisticRegression

spark = SparkSession.builder.master("local").getOrCreate()
spark.sparkContext.setLogLevel("ERROR")

# 1. Train Pipeline
train = spark.createDataFrame([(0,1.,3.),(1,2.,1.)], ["label","f1","f2"])
model = Pipeline(stages=[
    VectorAssembler(inputCols=["f1","f2"], outputCol="features"), 
    LogisticRegression()
]).fit(train)

# 2. Stream, Parse, Predict & Write
lines = spark.readStream.format("socket").option("host","127.0.0.1").option("port",9999).load()

# Use SQL expressions to compact the split/cast logic
data = lines.selectExpr("split(value, ',') as p").filter("size(p)=2") \
            .selectExpr("cast(p[0] as double) as f1", "cast(p[1] as double) as f2")

model.transform(data).select("f1","f2","prediction").writeStream \
     .format("console").outputMode("append").start().awaitTermination()