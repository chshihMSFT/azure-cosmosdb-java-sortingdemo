package sortingdemo;

import com.microsoft.azure.documentdb.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class App
{
    private static final String HOST = "URI";
    private static final String MASTER_KEY = "PrimaryKey";
    private static final String databaseId = "DBName";
    private static final String collectionId = "ContainerName";
    private static final String partitionKeyFieldName = "PartitionKey";
    private static final String partitionKeyPath = "/" + partitionKeyFieldName;
    private static final String collectionLink = String.format("/dbs/%s/colls/%s", databaseId, collectionId);

    private static DocumentClient documentclient;
    // We'll use Gson for POJO <=> JSON serialization for this example.

    private static ObjectMapper mapper = new ObjectMapper()
        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        .setSerializationInclusion(JsonInclude.Include.NON_NULL);

    public static void main( String[] args)
    {
        documentclient = new DocumentClient(HOST, MASTER_KEY, null, null);
        FeedOptions options = new FeedOptions();
        options.setEnableCrossPartitionQuery(true);

        TodoItem newitem = new TodoItem();
        newitem.setpk("testpk");
        newitem.seteventType("1");
        newitem.seteventStatus("2");
        newitem.seteventCreationType("3");
        newitem.setuNLocationCode("4");
        newitem.setlocationName("5");

        System.out.println("Create document ... ");
        try{
            System.out.println("newitem:\r\n" + mapper.writeValueAsString(newitem).toString());
            Document testresult = null;
            testresult = documentclient.createDocument(collectionLink, newitem, null, false).getResource();
            System.out.println("testresult:\r\n" + testresult.toString());
        }
        catch(Exception ce)
        {
            System.out.println(ce.toString());
        }

        /*
        Input / newitem:
            {"pk":"testpk","eventType":"1","eventStatus":"2","eventCreationType":"3","uNLocationCode":"4","locationName":"5"}

        Output / testresult:
            {"_attachments":"attachments/","eventCreationType":"3","_rid":"Ppx6AMzcdtmNhB4AAAAAAA==","locationName":"5","eventStatus":"2","uNLocationCode":"4","id":"29a28c67-7334-46e2-a28c-67733426e270","pk":"testpk","eventType":"1","_self":"dbs/Ppx6AA==/colls/Ppx6AMzcdtk=/docs/Ppx6AMzcdtmNhB4AAAAAAA==/","_etag":"\"0000d1bc-0000-0800-0000-5ee793c00000\"","_ts":1592234944}
        */

        List<TodoItem> outputarrlist = new ArrayList<>();
        try{
            System.out.println("Retrieve documents ... ");
            List<Document> documentList = documentclient.queryDocuments(collectionLink
                , "select * from root r order by r.id"
                , options)
                .getQueryIterable()
                .toList();

            System.out.println("De-serialize the documents ... ");
            for(Document document : documentList) {
                System.out.println("[id: " + document.getId() + "]");
                try {
                    outputarrlist.add(mapper.readValue(document.toString(),
                        TodoItem.class));
                } catch (Exception e) {
                    System.out.println(e.toString());
                }
            }

            String strDocJson = mapper.writeValueAsString(outputarrlist);
            System.out.println("Serialize as a JSON Document ... \r\n"
                + strDocJson.toString());
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }

    }
}
