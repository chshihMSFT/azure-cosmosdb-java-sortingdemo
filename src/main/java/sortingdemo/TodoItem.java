package sortingdemo;

public class TodoItem {

    public TodoItem() {
    }

    // 01
    public String geteventType() {
        return eventType;
    }
    public void seteventType(String eventType) {
        this.eventType = eventType;
    }

    // 02
    public String geteventStatus() {
        return eventStatus;
    }
    public void seteventStatus(String eventStatus) {
        this.eventStatus = eventStatus;
    }

    // 03
    public String geteventCreationType() {
        return eventCreationType;
    }
    public void seteventCreationType(String eventCreationType) {
        this.eventCreationType = eventCreationType;
    }

    // 04
    public String getuNLocationCode() {
        return uNLocationCode;
    }
    public void setuNLocationCode(String uNLocationCode) {
        this.uNLocationCode = uNLocationCode;
    }

    // 05
    public String getlocationName() {
        return locationName;
    }
    public void setlocationName(String locationName) {
        this.locationName = locationName;
    }

    // 06
    public String getterminalCode() {
        return terminalCode;
    }
    public void setterminalCode(String terminalCode) {
        this.terminalCode = terminalCode;
    }

    // 07
    public String getcontainerMovementType() {
        return containerMovementType;
    }
    public void setcontainerMovementType(String containerMovementType) {
        this.containerMovementType = containerMovementType;
    }

    // 08
    public String getcontainerNo() {
        return containerNo;
    }
    public void setcontainerNo(String containerNo) {
        this.containerNo = containerNo;
    }

    // 09
    public String getcontainerWeightInKG() {
        return containerWeightInKG;
    }
    public void setcontainerWeightInKG(String containerWeightInKG) {
        this.containerWeightInKG = containerWeightInKG;
    }

    // 10
    public String getcontainerSizeType() {
        return containerSizeType;
    }
    public void setcontainerSizeType(String containerSizeType) {
        this.containerSizeType = containerSizeType;
    }

    // 11
    public String getcontainerOperator() {
        return containerOperator;
    }
    public void setcontainerOperator(String containerOperator) {
        this.containerOperator = containerOperator;
    }

    // 12
    public String getblNo() {
        return blNo;
    }
    public void setblNo(String blNo) {
        this.blNo = blNo;
    }

    // 13
    public String getbookingRefNo() {
        return bookingRefNo;
    }
    public void setbookingRefNo(String bookingRefNo) {
        this.bookingRefNo = bookingRefNo;
    }

    // 14
    public String getloadDichargeVesselIMONo() {
        return loadDichargeVesselIMONo;
    }
    public void setloadDichargeVesselIMONo(String loadDichargeVesselIMONo) {
        this.loadDichargeVesselIMONo = loadDichargeVesselIMONo;
    }

    // 15
    public String getloadDichargeVesselOperator() {
        return loadDichargeVesselOperator;
    }
    public void setloadDichargeVesselOperator(String loadDichargeVesselOperator) {
        this.loadDichargeVesselOperator = loadDichargeVesselOperator;
    }

    // 16
    public String getloadDischargeVesselName() {
        return loadDischargeVesselName;
    }
    public void setloadDischargeVesselName(String loadDischargeVesselName) {
        this.loadDischargeVesselName = loadDischargeVesselName;
    }

    // 17
    public String getloadDischargeVoyageNo() {
        return loadDischargeVoyageNo;
    }
    public void setloadDischargeVoyageNo(String loadDischargeVoyageNo) {
        this.loadDischargeVoyageNo = loadDischargeVoyageNo;
    }

    // 18
    public String geteventDate() {
        return eventDate;
    }
    public void seteventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    // 19
    public String gethaulierCompanyName() {
        return haulierCompanyName;
    }
    public void sethaulierCompanyName(String haulierCompanyName) {
        this.haulierCompanyName = haulierCompanyName;
    }

    // 20
    public String getvehicleId() {
        return vehicleId;
    }
    public void setvehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    // 21
    public String getorigin() {
        return origin;
    }
    public void setorigin(String origin) {
        this.origin = origin;
    }

    // 22
    public String getdestination() {
        return destination;
    }
    public void setdestination(String destination) {
        this.destination = destination;
    }

    // 23
    public String getpoL() {
        return poL;
    }
    public void setpoL(String poL) {
        this.poL = poL;
    }

    // 24
    public String getpoD() {
        return poD;
    }
    public void setpoD(String poD) {
        this.poD = poD;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getpk() {
        return pk;
    }
    public void setpk(String pk) {
        this.pk = pk;
    }

    private String id;
    private String pk;
    private String eventType;                   // 01
    private String eventStatus;                 // 02
    private String eventCreationType;           // 03
    private String uNLocationCode;              // 04
    private String locationName;                // 05
    private String terminalCode;                // 06
    private String containerMovementType;       // 07
    private String containerNo;                 // 08
    private String containerWeightInKG;         // 09
    private String containerSizeType;           // 10
    private String containerOperator;           // 11
    private String blNo;                        // 12
    private String bookingRefNo;                // 13
    private String loadDichargeVesselIMONo;     // 14
    private String loadDichargeVesselOperator;  // 15
    private String loadDischargeVesselName;     // 16
    private String loadDischargeVoyageNo;       // 17
    private String eventDate;                   // 18
    private String haulierCompanyName;          // 19
    private String vehicleId;                   // 20
    private String origin;                      // 21
    private String destination;                 // 22
    private String poL;                         // 23
    private String poD;                         // 24

}