/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.kaiwaehner.kafka.connect.smt;

import org.apache.kafka.common.config.ConfigDef;
import org.apache.kafka.connect.connector.ConnectRecord;
import org.apache.kafka.connect.errors.DataException;
import org.apache.kafka.connect.transforms.Transformation;
import org.apache.kafka.connect.transforms.util.SimpleConfig;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.TimeZone;

public class StringFilter<R extends ConnectRecord<R>> implements Transformation<R> {

    private static final String TOPIC = "${topic}";

    public static final String OVERVIEW_DOC =
            "Update the record's topic field as a function of the original topic value and the record timestamp."
                    + "<p/>"
                    + "This is mainly useful for sink connectors, since the topic field is often used to determine the equivalent entity name in the destination system"
                    + "(e.g. database table or search index name).";

    public static final ConfigDef CONFIG_DEF = new ConfigDef()
            .define(ConfigName.TOPIC_FORMAT, ConfigDef.Type.STRING, "${topic}", ConfigDef.Importance.HIGH,
                    "Format string which can contain <code>${topic}</code> and <code>${timestamp}</code> as placeholders for the topic and timestamp, respectively.");

    private interface ConfigName {
         String TOPIC_FORMAT = "topic.format";
    }

    private String topicFormat;

    @Override
    public void configure(Map<String, ?> props) {
        final SimpleConfig config = new SimpleConfig(CONFIG_DEF, props);

        topicFormat = config.getString(ConfigName.TOPIC_FORMAT);
    }

    @Override
    public R apply(R record) {


        //final String replace1 = TOPIC.matcher(topicFormat).replaceAll(Matcher.quoteReplacement(record.topic()));
		//final String updatedTopic = TIMESTAMP.matcher(replace1).replaceAll(Matcher.quoteReplacement(formattedTimestamp));
		
		final String updatedTopic = "KAI";

        return record.newRecord(
                updatedTopic, record.kafkaPartition(),
                record.keySchema(), record.key(),
                record.valueSchema(), record.value(),
                record.timestamp()
        );
    }

    @Override
    public void close() {
    }

  @Override
    public ConfigDef config() {
        return CONFIG_DEF;
    }

}