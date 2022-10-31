import Task14v1.Rewards;
import Task14v1.User.Users;
import Task15.Repository.DataBase;
import Task15.Serrializer.LocalDateDeserialize;
import Task15.Serrializer.LocalDateSerialize;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
public class Task16 {
    public static void main(String[] args) throws IOException {
        SimpleModule localDateTimeSerialization = new SimpleModule();
        localDateTimeSerialization.addSerializer(LocalDate.class, new LocalDateSerialize()).addDeserializer(LocalDateTime.class,new LocalDateDeserialize());

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(localDateTimeSerialization).enable(SerializationFeature.WRAP_ROOT_VALUE).enable(DeserializationFeature.UNWRAP_ROOT_VALUE);
        Users users = new Users("334","fddfdf",LocalDate.of(1998,4,4));
        String JsonResult = objectMapper.writeValueAsString(users);
        DataBase dataBase = new DataBase();
        String as =  dataBase.getObjFromID(1).replace('[',' ').replace(']',' ');

       System.out.println(JsonResult);
       System.out.println(as);
       Users users1 = objectMapper.readValue(as,Users.class);
       System.out.println(users1.getId());


















    }
}



