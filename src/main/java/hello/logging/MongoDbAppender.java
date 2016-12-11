package hello.logging;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBCollection;

import ch.qos.logback.classic.spi.LoggingEvent;
import ch.qos.logback.core.AppenderBase;
import hello.model.Person;

@Component
public class MongoDbAppender extends AppenderBase<LoggingEvent> {
	
	private final Logger logger = LoggerFactory.getLogger(MongoDbAppender.class);
	
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	protected void append(LoggingEvent e) {
		BasicDBObjectBuilder objectBuilder = BasicDBObjectBuilder.start().
				add("ts", new Date(e.getTimeStamp())).
				add("msg", e.getFormattedMessage()).
				add("level", e.getLevel().toString()).
				add("logger", e.getLoggerName()).
				add("thread", e.getThreadName());
		if(e.hasCallerData()) {
			StackTraceElement st = e.getCallerData()[0];
			String callerData = String.format("%s.%s:%d", st.getClassName(), st.getMethodName(), st.getLineNumber());
			objectBuilder.add("caller", callerData);
		}
		Map<String, String> mdc = e.getMdc();
		if(mdc != null && !mdc.isEmpty()) {
			objectBuilder.add("mdc", new BasicDBObject(mdc) );
		}
		logger.info("Inserted log into the collection "+"LOG-"+e.getLevel().toString());
		DBCollection collection = mongoTemplate.getCollection("LOG-"+e.getLevel().toString());  
		logger.debug("Getting the collection name : "+collection.getFullName());
		collection.insert(objectBuilder.get());
	}

}


