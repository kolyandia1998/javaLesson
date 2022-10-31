package Task15.Serrializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class LocalDateDeserialize  extends JsonDeserializer<LocalDateTime> {
        private final DateTimeFormatter fmt = DateTimeFormatter.ISO_LOCAL_DATE;
        @Override
        public LocalDateTime deserialize(JsonParser p, DeserializationContext context) throws IOException {
            return LocalDateTime.parse(p.getValueAsString(), fmt);
        }

    }

