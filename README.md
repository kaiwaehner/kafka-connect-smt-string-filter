# Single Message Transformation (SMT) for Kafka Connect to Filter String Messages

Single Message Transformation (SMT) is a great way to process single events as part of Kafka Connect's integration flow. No need to write source code. Just configuration as part of setting up your Kafka Connector connector.

This project shows how to build a simple SMT to filter String messages. If you want to build a SMT to process / transfor / filter / enrich / route a Struct or List event, this is hopefully still valuable: Understand the basics first, then take a look at the [source code of one of the other existing SMTs in the Kafka project on Github](https://github.com/apache/kafka/tree/trunk/connect/transforms/src/main/java/org/apache/kafka/connect/transforms) or check the [Unit Tests for these Transforms](https://github.com/apache/kafka/tree/trunk/connect/transforms/src/test/java/org/apache/kafka/connect/transforms).

## Intro to Single Message Transformation (SMT)

TODO Picture
TODO Link to Docs
TODO Link to Kafka Summit Video 

TODO Comparison to Kafka Streams

## How to built a custom SMT?

- Create new Github project with Maven Build + Apache Kafka dependency (for SMT API)
- Build a simple “String Filter SMT”, e.g. by using another SMT as template, like [TimestampRouter SMT for String messages](https://github.com/apache/kafka/blob/trunk/connect/transforms/src/main/java/org/apache/kafka/connect/transforms/TimestampRouter.java)
- Build and generate JAR (without Kafka dependencies)
- Add the JAR to default Connect plugin path
- Start Connect via Confluent CLI
- Add connector including the SMT
- Test it

## Source Code Snippet
TODO

## Unit Test
TODO