package cooperation.huangye;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.cs.huangye.citypages.citypages.CityPagesInfo;
import tencent.im.cs.huangye.citypages.citypages.GeoInfo;
import tencent.im.cs.huangye.citypages.citypages.TelInfo;

public class HYBusinessInfo
  extends Entity
{
  private static final String TAG = "YPBusinessRecord";
  @unique
  public String bId;
  public String background;
  @notColumn
  public int categoryTypePosition;
  public boolean hasDetail;
  @notColumn
  public int itemType;
  public String jsonPhones;
  public HYLocationInfo locationInfo;
  public String logoUrl;
  @notColumn
  private boolean mFollow;
  @notColumn
  private boolean mHadQueryFollowType;
  public String name;
  @notColumn
  public HYBusinessInfo.HYPhoneInfo[] phone;
  public String pinyinAll;
  public String pinyinFirst;
  public String site;
  public String slogan;
  public int sub_cat_id;
  public String topic;
  public long updateTime;
  
  public HYBusinessInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.categoryTypePosition = -1;
    this.locationInfo = new HYLocationInfo();
  }
  
  public HYBusinessInfo(citypages.CityPagesInfo paramCityPagesInfo)
  {
    this.categoryTypePosition = -1;
    this.locationInfo = new HYLocationInfo();
    copyFromCityPagesInfo(paramCityPagesInfo);
  }
  
  public static String tableName()
  {
    return "mr_huangye_bussiness";
  }
  
  public void copyFromCityPagesInfo(citypages.CityPagesInfo paramCityPagesInfo)
  {
    this.bId = paramCityPagesInfo.id.get();
    this.name = paramCityPagesInfo.name.get();
    this.logoUrl = paramCityPagesInfo.logo.get();
    if (paramCityPagesInfo.tels.size() > 0)
    {
      this.phone = new HYBusinessInfo.HYPhoneInfo[paramCityPagesInfo.tels.size()];
      int i = 0;
      while (i < paramCityPagesInfo.tels.size())
      {
        this.phone[i] = new HYBusinessInfo.HYPhoneInfo();
        this.phone[i].jdField_b_of_type_JavaLangString = ((citypages.TelInfo)paramCityPagesInfo.tels.get(i)).telDesc.get();
        this.phone[i].a = ((citypages.TelInfo)paramCityPagesInfo.tels.get(i)).tel.get();
        i += 1;
      }
    }
    this.locationInfo.jdField_b_of_type_Long = paramCityPagesInfo.geo.lat.get();
    this.locationInfo.c = paramCityPagesInfo.geo.lon.get();
    this.locationInfo.a = paramCityPagesInfo.distance.get();
    this.locationInfo.jdField_b_of_type_JavaLangString = paramCityPagesInfo.addr.get();
    this.site = paramCityPagesInfo.site.get();
    this.slogan = paramCityPagesInfo.slogan.get();
    this.background = paramCityPagesInfo.background.get();
    this.sub_cat_id = paramCityPagesInfo.sub_cat_id.get();
    this.topic = paramCityPagesInfo.topic.get();
    this.hasDetail = true;
  }
  
  protected Class getClassForTable()
  {
    return HYBusinessInfo.class;
  }
  
  public String getTableName()
  {
    return tableName();
  }
  
  public boolean isFollow()
  {
    if (this.mHadQueryFollowType) {
      return this.mFollow;
    }
    return false;
  }
  
  protected void postRead()
  {
    if ((this.jsonPhones != null) && (!this.jsonPhones.equals(""))) {
      try
      {
        JSONArray localJSONArray = new JSONArray(this.jsonPhones);
        if (localJSONArray.length() > 0)
        {
          this.phone = new HYBusinessInfo.HYPhoneInfo[localJSONArray.length()];
          int i = 0;
          while (i < localJSONArray.length())
          {
            JSONObject localJSONObject = localJSONArray.getJSONObject(i);
            this.phone[i] = new HYBusinessInfo.HYPhoneInfo();
            this.phone[i].a = localJSONObject.getString("number");
            this.phone[i].jdField_b_of_type_JavaLangString = localJSONObject.getString("desc");
            i += 1;
          }
        }
        return;
      }
      catch (JSONException localJSONException) {}
    }
  }
  
  protected void prewrite()
  {
    if ((this.phone != null) && (this.phone.length > 0)) {}
    try
    {
      JSONArray localJSONArray = new JSONArray();
      int i = 0;
      while (i < this.phone.length)
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("number", this.phone[i].a);
        localJSONObject.put("desc", this.phone[i].jdField_b_of_type_JavaLangString);
        localJSONArray.put(localJSONObject);
        i += 1;
      }
      this.jsonPhones = localJSONArray.toString();
      return;
    }
    catch (JSONException localJSONException) {}
  }
  
  public void setFollow(boolean paramBoolean)
  {
    this.mHadQueryFollowType = true;
    this.mFollow = paramBoolean;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\huangye\HYBusinessInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */