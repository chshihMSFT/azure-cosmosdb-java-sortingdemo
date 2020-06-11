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

        List<democlass> outputarrlist = new ArrayList<>();
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
                        democlass.class));
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
