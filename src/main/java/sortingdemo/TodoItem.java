package sortingdemo;

public class TodoItem {

    public TodoItem() {
    }

    private String id;
    private String pk;
    private String eventType;                   // 01
    private String eventStatus;                 // 02
    private String eventCreationType;           // 03
    private String uNLocationCode;              // 04
    private String locationName;                // 05
    private String _rid;
    private String _self;
    private String _etag;
    private String _attachments;
    private String _ts;

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
    
    //system attributes
    public String get_rid() {
        return _rid;
    }
    public void set_rid(String _rid) {
        this._rid = _rid;
    }

    public String get_self() {
        return _self;
    }
    public void set_self(String _self) {
        this._self = _self;
    }

    public String get_etag() {
        return _etag;
    }
    public void set_etag(String _etag) {
        this._etag = _etag;
    }

    public String get_attachments() {
        return _attachments;
    }
    public void setattachments(String _attachments) {
        this._attachments = _attachments;
    }
    
    public String get_ts() {
        return _ts;
    }
    public void set_ts(String _ts) {
        this._ts = _ts;
    }


}