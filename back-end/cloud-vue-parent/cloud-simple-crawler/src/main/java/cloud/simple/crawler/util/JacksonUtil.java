package cloud.simple.crawler.util;

import cloud.simple.crawler.model.TeamData;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Date;

public class JacksonUtil {
	  /**
     * jackson实现object转json
     * @param obj
     * @return String
     */
    public static String createJsDataByJackson(Object obj)
    {
        ObjectMapper mapper = new ObjectMapper();
        String result = "";
        try
        {
            result = mapper.writeValueAsString(obj);
        }
        catch (JsonGenerationException e)
        {
            // TODO 异常处理
            e.printStackTrace();
        }
        catch (JsonMappingException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return result;
    }
    /**
     * jackson实现json转object
     * @param json
     * @param valueType
     * @param <T>
     * @return
     */
    public static <T> T createObjectByJackson(String json, Class<T> valueType)
    {

        ObjectMapper mapper = new ObjectMapper();
        T t = null;
        try
        {
            t = (T) mapper.readValue(json,valueType);
        }
        catch (JsonParseException e)
        {
            e.printStackTrace();
        }
        catch (JsonMappingException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return t;
    }
    public static void main(String[] args) {
    	//jackson有很多强大的注解，可以规定json格式，json解析策略
    	// jackson annotations注解详解
		String jsonstr = "{\"status\":1,\"VedioList\":[{\"Path\":\"/Content/Files/Answer/71fc8b6a-5d41-4e8d-9b4e-9a69b420506f.MOV\",\"TaskName\":\"「支线任务」舞动青春\",\"Suffix\":\"MOV\"},{\"Path\":\"/Content/Files/Answer/a1898f5a-458b-4677-bee3-d86dc1440fe1.MOV\",\"TaskName\":\"「支线任务」耍嘴皮子\",\"Suffix\":\"MOV\"},{\"Path\":\"/Content/Files/Answer/cb04795b-e211-4778-9cca-6597b8f4cb13.mp4\",\"TaskName\":\"「支线任务」蒙混过关\",\"Suffix\":\"mp4\"},{\"Path\":\"/Content/Files/Answer/23d2b83e-96cc-4d4d-94a9-33402048c027.MOV\",\"TaskName\":\"「主线任务」女汉子\",\"Suffix\":\"MOV\"},{\"Path\":\"/Content/Files/Answer/bd2d63d0-5ca5-4a9e-908d-a0dc6ba9a1d3.MOV\",\"TaskName\":\"「支线任务」姐妹情深\",\"Suffix\":\"MOV\"},{\"Path\":\"/Content/Files/Answer/ae403e4c-7c4b-4d6a-9191-0a3e5f10e0c3.MOV\",\"TaskName\":\"「支线任务」自报名号\",\"Suffix\":\"MOV\"}],\"PicList\":[{\"Path\":\"/Content/Files/Answer/5e3b0ddc-a5c0-46ae-a482-c0572fded248.jpg\",\"TaskName\":\"「支线任务」白骨精\"},{\"Path\":\"/Content/Files/Answer/4f457753-2e47-4420-a6f4-f045850cc765.jpg\",\"TaskName\":\"「支线任务」来自星星的你\"},{\"Path\":\"/Content/Files/Answer/65498b56-d836-40a1-a402-a6665b774d03.jpg\",\"TaskName\":\"「支线任务」女中豪杰\"},{\"Path\":\"/Content/Files/Answer/a3470684-fdc4-4a08-bf3f-b4689b43030e.jpg\",\"TaskName\":\"「主线任务」奔跑吧！女王！\"},{\"Path\":\"/Content/Files/Answer/4a03ac96-0bfc-4f48-a06b-f7e9715c58b7.jpg\",\"TaskName\":\"「支线任务」萌萌哒\"},{\"Path\":\"/Content/Files/Answer/d46e7818-703b-4c59-a2bf-df69fc9e9d1e.jpg\",\"TaskName\":\"「支线任务」抚媚众生\"},{\"Path\":\"/Content/Files/Answer/f4b1ecc3-8ef2-4da3-b608-c168b0188b64.jpg\",\"TaskName\":\"「主线任务」千手观音\"},{\"Path\":\"/Content/Files/Answer/a5333b24-67ee-4a11-a986-80ae2a4168f3.jpg\",\"TaskName\":\"「支线任务」心心相印\"},{\"Path\":\"/Content/Files/Answer/f1b29e78-d590-4791-926b-ec60d9b11b70.jpg\",\"TaskName\":\"「支线任务」环保卫士\"}]}" ;
		System.out.println(jsonstr);
        TeamData data = createObjectByJackson(jsonstr, TeamData.class);
		System.out.println(data);
	}

}
