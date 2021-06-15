package businesskeywords;

import com.gurock.testrail.APIClient;
import com.gurock.testrail.APIException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TestRail {

    public static void main(String[] args) throws IOException, APIException {
        APIClient client = new APIClient("https://hellonimbly.testrail.io");
        client.setUser("gopesh@hellonimbly.com");
        client.setPassword("Lieutenant@2");//get_sections/:4&suite_id=:1
        JSONArray sectionList = (JSONArray) client.sendGet("get_sections/1&1");
        ArrayList casesID = new ArrayList();
        for (Object jobj : sectionList) {
            HashMap<String, Object> jMap = (HashMap<String, Object>) jobj;
            for (String key : jMap.keySet()) {
                if (key.equals("name")) {
                    String name = (String) jMap.get("name");
                    if (name.equals("Smoke")) {
                        long section_id = (long) jMap.get("id");
                        System.out.println(section_id);
                        JSONArray cases = (JSONArray) client.sendGet("get_cases/1&1&section_id="+section_id);
                        System.out.println(cases);
                        for (Object obj : cases) {
                            HashMap<String, Object> caseMap = (HashMap<String, Object>) obj;
                            long caseID = (long) caseMap.get("id");
                            int cId= (int) caseID;

                            casesID.add(cId);

                        }
                        break;

                    }

                }
            }

        }
        Map<String, Object> addRunMap = new HashMap<>();

        addRunMap.put("suite_id", 1);
        addRunMap.put("name", "Auto_Demo_Run");
        addRunMap.put("include_all", false);
        addRunMap.put("case_ids", casesID);


      //JSONObject addRun = (JSONObject) client.sendPost("add_run/1", addRunMap);
     // long runId = (long) addRun.get("id");

    }

}

