package sortingdemo;

import com.azure.cosmos.*;
import com.azure.cosmos.models.CosmosContainerProperties;
import com.azure.cosmos.models.CosmosContainerResponse;
import com.azure.cosmos.models.CosmosDatabaseResponse;
import com.azure.cosmos.models.CosmosItemRequestOptions;
import com.azure.cosmos.models.CosmosItemResponse;
import com.azure.cosmos.models.CosmosQueryRequestOptions;
import com.azure.cosmos.models.ThroughputProperties;
import com.azure.cosmos.util.CosmosPagedIterable;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.UUID;

public class App
{
    private static final String HOST = "URI";
    private static final String MASTER_KEY = "PrimaryKey";
    private static final String databaseId = "DBName";
    private static final String collectionId = "ContainerName";
    private static final String partitionKeyFieldName = "PartitionKey";
    private static final String partitionKeyPath = "/" + partitionKeyFieldName;

    private static CosmosClient cosmoslient;
    private static CosmosDatabase database;
    private static CosmosContainer container;
    private static UUID uuid;

    private static ObjectMapper mapper = new ObjectMapper()
        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        .setSerializationInclusion(JsonInclude.Include.NON_NULL);

    public static void main( String[] args)
    {
        cosmoslient = new CosmosClientBuilder()
                .endpoint(HOST)
                .key(MASTER_KEY)
                .buildClient();

        CosmosDatabaseResponse databaseResponse = cosmoslient.createDatabaseIfNotExists(databaseId);
        database = cosmoslient.getDatabase(databaseResponse.getProperties().getId());
        CosmosContainerProperties containerProperties = new CosmosContainerProperties(collectionId, partitionKeyPath);
        ThroughputProperties throughputProperties = ThroughputProperties.createManualThroughput(400);
        CosmosContainerResponse containerResponse = database.createContainerIfNotExists(containerProperties, throughputProperties);
        container = database.getContainer(containerResponse.getProperties().getId());

        TodoItem newitem = new TodoItem();
        newitem.setId(uuid.randomUUID().toString());
        newitem.setpk("testpk");
        newitem.seteventType("1");
        newitem.seteventStatus("2");
        newitem.seteventCreationType("3");
        newitem.setuNLocationCode("4");
        newitem.setlocationName("5");
        newitem.setterminalCode("6");
        newitem.setcontainerMovementType("7");
        newitem.setcontainerNo("8");
        newitem.setcontainerWeightInKG("9");
        newitem.setcontainerSizeType("10");
        newitem.setcontainerOperator("11");
        newitem.setblNo("12");
        newitem.setbookingRefNo("13");
        newitem.setloadDichargeVesselIMONo("14");
        newitem.setloadDichargeVesselOperator("15");
        newitem.setloadDischargeVesselName("16");
        newitem.setloadDischargeVoyageNo("17");
        newitem.seteventDate("18");
        newitem.sethaulierCompanyName("19");
        newitem.setvehicleId("20");
        newitem.setorigin("21");
        newitem.setdestination("22");
        newitem.setpoL("23");
        newitem.setpoD("24");

        System.out.println("Create a document ... ");
        try{
            CosmosItemResponse<TodoItem> testresult;
            testresult = container.createItem(newitem, new CosmosItemRequestOptions());
            System.out.println("Status: " + testresult.getStatusCode());
            System.out.println("Diagnostics: \r\n" + testresult.getDiagnostics());
        }
        catch(Exception ce)
        {
            System.out.println(ce.toString());
        }

        System.out.println("Retrieve documents ... ");
        try{
            String sql = "SELECT * FROM c";
            CosmosPagedIterable<TodoItem> itemlists = container.queryItems(sql, new CosmosQueryRequestOptions(), TodoItem.class);

            for (TodoItem item : itemlists) {
                System.out.println(mapper.writeValueAsString(item).toString());
            }
        }
        catch (Exception ce) {
            System.out.println(ce.toString());
        }

    }
}
