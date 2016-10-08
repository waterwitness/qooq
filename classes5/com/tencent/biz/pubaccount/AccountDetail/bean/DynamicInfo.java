package com.tencent.biz.pubaccount.AccountDetail.bean;

import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DynamicInfo
{
  public static final String a;
  public static final String b = "msg";
  public static final String c = "item";
  public static final String d = "item_attr";
  public static final String e = "item_";
  public static final String f = "title";
  public static final String g = "video";
  public static final String h = "picture";
  public static final String i = "video_attr";
  public static final String j = "picture_attr";
  public static final String k = "cover";
  public static final String l = "busitype";
  public static final String m = "cover";
  public static final String n = "fulltime";
  public static final String o = "h5url";
  public static final String p = "preheight";
  public static final String q = "prewidth";
  public static final String r = "vid";
  public static final String s = "msg_attr";
  public static final String t = "articleid";
  public static final String u = "id";
  public static final String v = "jumpurl";
  public static final String w = "msgtype";
  public static final String x = "tasktype";
  public static final String y = "time";
  public static final String z = "uniqueid";
  public String A;
  public String B;
  public String C;
  public MsgAttr a;
  public PictureAttr a;
  public VideoAttr a;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = DynamicInfo.class.getSimpleName();
  }
  
  private void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject.has("title")) {
      this.A = paramJSONObject.getString("title");
    }
    if (paramJSONObject.has("video")) {
      this.B = paramJSONObject.getString("video");
    }
    if (paramJSONObject.has("picture")) {
      this.C = paramJSONObject.getString("picture");
    }
    if (paramJSONObject.has("picture_attr")) {
      c(paramJSONObject.getJSONObject("picture_attr"));
    }
    if (paramJSONObject.has("video_attr")) {
      d(paramJSONObject.getJSONObject("video_attr"));
    }
  }
  
  private void b(JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBeanMsgAttr = null;
    if (paramJSONObject != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBeanMsgAttr = new MsgAttr();
      if (paramJSONObject.has("articleid")) {
        this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBeanMsgAttr.jdField_a_of_type_Long = paramJSONObject.getLong("articleid");
      }
      if (paramJSONObject.has("id")) {
        this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBeanMsgAttr.jdField_b_of_type_Long = paramJSONObject.getLong("id");
      }
      if (paramJSONObject.has("jumpurl")) {
        this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBeanMsgAttr.jdField_a_of_type_JavaLangString = paramJSONObject.getString("jumpurl");
      }
      if (paramJSONObject.has("msgtype")) {
        this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBeanMsgAttr.jdField_a_of_type_Int = paramJSONObject.getInt("msgtype");
      }
      if (paramJSONObject.has("tasktype")) {
        this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBeanMsgAttr.jdField_b_of_type_Int = paramJSONObject.getInt("tasktype");
      }
      if (paramJSONObject.has("time")) {
        this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBeanMsgAttr.c = paramJSONObject.getLong("time");
      }
      if (paramJSONObject.has("uniqueid")) {
        this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBeanMsgAttr.d = paramJSONObject.getLong("uniqueid");
      }
    }
  }
  
  private void c(JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBeanPictureAttr = null;
    if (paramJSONObject != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBeanPictureAttr = new PictureAttr();
      if (paramJSONObject.has("cover")) {
        this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBeanPictureAttr.jdField_a_of_type_JavaLangString = paramJSONObject.getString("cover");
      }
    }
  }
  
  private void d(JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBeanVideoAttr = null;
    if (paramJSONObject != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBeanVideoAttr = new VideoAttr();
      if (paramJSONObject.has("busitype")) {
        this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBeanVideoAttr.jdField_a_of_type_Int = paramJSONObject.getInt("busitype");
      }
      if (paramJSONObject.has("cover")) {
        this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBeanVideoAttr.jdField_a_of_type_JavaLangString = paramJSONObject.getString("cover");
      }
      if (paramJSONObject.has("fulltime")) {
        this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBeanVideoAttr.jdField_b_of_type_Int = paramJSONObject.getInt("fulltime");
      }
      if (paramJSONObject.has("h5url")) {
        this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBeanVideoAttr.jdField_b_of_type_JavaLangString = paramJSONObject.getString("h5url");
      }
      if (paramJSONObject.has("preheight")) {
        this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBeanVideoAttr.jdField_c_of_type_Int = paramJSONObject.getInt("preheight");
      }
      if (paramJSONObject.has("prewidth")) {
        this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBeanVideoAttr.d = paramJSONObject.getInt("prewidth");
      }
      if (paramJSONObject.has("vid")) {
        this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBeanVideoAttr.jdField_c_of_type_JavaLangString = paramJSONObject.getString("vid");
      }
    }
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        if (paramString.has("msg"))
        {
          Object localObject = paramString.getJSONObject("msg");
          if (((JSONObject)localObject).has("item"))
          {
            localObject = ((JSONObject)localObject).getJSONArray("item");
            int i1;
            JSONArray localJSONArray;
            if (localObject == null)
            {
              i1 = 0;
              break label184;
              if (i2 >= i1) {
                continue;
              }
              localJSONArray = ((JSONArray)localObject).getJSONArray(i2);
              if (localJSONArray == null)
              {
                i3 = 0;
                break label190;
                if (i4 >= i3) {
                  break label196;
                }
                a(localJSONArray.getJSONObject(i4));
                i4 += 1;
                continue;
              }
            }
            else
            {
              i1 = ((JSONArray)localObject).length();
              break label184;
            }
            int i3 = localJSONArray.length();
            break label190;
          }
        }
        if (!paramString.has("msg_attr")) {
          break;
        }
        b(paramString.getJSONObject("msg_attr"));
        return;
      }
      catch (JSONException paramString) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(jdField_a_of_type_JavaLangString, 2, "DynamicInfo Exception:" + paramString.getMessage());
      return;
      label184:
      int i2 = 0;
      continue;
      label190:
      int i4 = 0;
      continue;
      label196:
      i2 += 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\AccountDetail\bean\DynamicInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */