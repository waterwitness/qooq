package com.tencent.mobileqq.data;

import android.text.TextUtils;
import android.util.Base64;
import appoint.define.appoint_define.CommonLabel;
import appoint.define.appoint_define.PublisherInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class StrangerInfo
  extends Entity
  implements Serializable
{
  private static final long serialVersionUID = 0L;
  public int age;
  public int charm;
  public int charmLevel;
  public int chatFlag;
  public int chatupCount;
  public String constellation;
  public String distance;
  public int gender;
  public int godFlag;
  public String interestNameStr;
  @notColumn
  public ArrayList interestNames;
  public String interestTypeStr;
  @notColumn
  public ArrayList interestTypes;
  @notColumn
  public boolean isNewVisitor;
  public int lableId;
  public byte[] lableMsgLast;
  public byte[] lableMsgPre;
  public int marriage;
  public String nickName;
  public int profession;
  public int pubNumber;
  public int recentVisitorTime;
  public int recommend;
  public byte[] strangerDeclare;
  @notColumn
  public String timeStr;
  public long tinyId;
  public long uin;
  public String vipInfo;
  
  public StrangerInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.interestNames = new ArrayList();
    this.interestTypes = new ArrayList();
  }
  
  public static StrangerInfo convertFrom(appoint_define.PublisherInfo paramPublisherInfo)
  {
    long l2 = 0L;
    JSONObject localJSONObject1 = null;
    int j = 0;
    if (paramPublisherInfo == null) {
      return null;
    }
    StrangerInfo localStrangerInfo = new StrangerInfo();
    int i;
    label66:
    label91:
    label116:
    label141:
    Object localObject1;
    label165:
    label188:
    label212:
    label237:
    long l1;
    if (paramPublisherInfo.uint32_age.has())
    {
      i = paramPublisherInfo.uint32_age.get();
      localStrangerInfo.age = i;
      if (!paramPublisherInfo.uint32_charm.has()) {
        break label737;
      }
      i = paramPublisherInfo.uint32_charm.get();
      localStrangerInfo.charm = i;
      if (!paramPublisherInfo.uint32_charm_level.has()) {
        break label743;
      }
      i = paramPublisherInfo.uint32_charm_level.get();
      localStrangerInfo.charmLevel = i;
      if (!paramPublisherInfo.uint32_chatflag.has()) {
        break label749;
      }
      i = paramPublisherInfo.uint32_chatflag.get();
      localStrangerInfo.chatFlag = i;
      if (!paramPublisherInfo.uint32_chatup_count.has()) {
        break label755;
      }
      i = paramPublisherInfo.uint32_chatup_count.get();
      localStrangerInfo.chatupCount = i;
      if (!paramPublisherInfo.str_constellation.has()) {
        break label761;
      }
      localObject1 = paramPublisherInfo.str_constellation.get();
      localStrangerInfo.constellation = ((String)localObject1);
      if (!paramPublisherInfo.str_distance.has()) {
        break label768;
      }
      localObject1 = paramPublisherInfo.str_distance.get();
      localStrangerInfo.distance = ((String)localObject1);
      if (!paramPublisherInfo.uint32_gender.has()) {
        break label775;
      }
      i = paramPublisherInfo.uint32_gender.get();
      localStrangerInfo.gender = i;
      if (!paramPublisherInfo.uint32_godflag.has()) {
        break label781;
      }
      i = paramPublisherInfo.uint32_godflag.get();
      localStrangerInfo.godFlag = i;
      if (!paramPublisherInfo.uint64_tinyid.has()) {
        break label787;
      }
      l1 = paramPublisherInfo.uint64_tinyid.get();
      label262:
      localStrangerInfo.tinyId = l1;
      if (!paramPublisherInfo.bytes_nickname.has()) {
        break label793;
      }
      localObject1 = paramPublisherInfo.bytes_nickname.get().toStringUtf8();
      label289:
      localStrangerInfo.nickName = ((String)localObject1);
      if (!paramPublisherInfo.uint32_marriage.has()) {
        break label800;
      }
      i = paramPublisherInfo.uint32_marriage.get();
      label313:
      localStrangerInfo.marriage = i;
      if (!paramPublisherInfo.uint32_profession.has()) {
        break label806;
      }
      i = paramPublisherInfo.uint32_profession.get();
      label338:
      localStrangerInfo.profession = i;
      if (!paramPublisherInfo.uint32_recent_vistor_time.has()) {
        break label812;
      }
      i = paramPublisherInfo.uint32_recent_vistor_time.get();
      label363:
      localStrangerInfo.recentVisitorTime = i;
      if (!paramPublisherInfo.str_vipinfo.has()) {
        break label818;
      }
      localObject1 = paramPublisherInfo.str_vipinfo.get();
      label387:
      localStrangerInfo.vipInfo = ((String)localObject1);
      if (!paramPublisherInfo.uint32_recommend.has()) {
        break label825;
      }
      i = paramPublisherInfo.uint32_recommend.get();
      label411:
      localStrangerInfo.recommend = i;
      if (!paramPublisherInfo.uint32_pub_number.has()) {
        break label831;
      }
      i = paramPublisherInfo.uint32_pub_number.get();
      label436:
      localStrangerInfo.pubNumber = i;
      l1 = l2;
      if (paramPublisherInfo.uint64_friend_uin.has()) {
        l1 = paramPublisherInfo.uint64_friend_uin.get();
      }
      localStrangerInfo.uin = l1;
      if (!paramPublisherInfo.bytes_stranger_declare.has()) {
        break label837;
      }
      localObject1 = Base64.decode(paramPublisherInfo.bytes_stranger_declare.get().toByteArray(), 0);
      label496:
      localStrangerInfo.strangerDeclare = ((byte[])localObject1);
      if ((!paramPublisherInfo.uint32_history_flag.has()) || (paramPublisherInfo.uint32_history_flag.get() != 1)) {
        break label842;
      }
      localStrangerInfo.isNewVisitor = false;
      label527:
      if (!paramPublisherInfo.msg_common_label.has()) {
        break label850;
      }
      paramPublisherInfo = (appoint_define.CommonLabel)paramPublisherInfo.msg_common_label.get();
      label548:
      if (paramPublisherInfo == null) {
        break label1033;
      }
      i = j;
      if (paramPublisherInfo.uint32_lable_id.has()) {
        i = paramPublisherInfo.uint32_lable_id.get();
      }
      localStrangerInfo.lableId = i;
      if (!paramPublisherInfo.bytes_lable_msg_pre.has()) {
        break label855;
      }
      localObject1 = paramPublisherInfo.bytes_lable_msg_pre.get().toByteArray();
      label602:
      localStrangerInfo.lableMsgPre = ((byte[])localObject1);
      if (!paramPublisherInfo.bytes_lable_msg_last.has()) {
        break label860;
      }
      localObject1 = paramPublisherInfo.bytes_lable_msg_last.get().toByteArray();
      label628:
      localStrangerInfo.lableMsgLast = ((byte[])localObject1);
      if (!paramPublisherInfo.rpt_interst_name.has()) {
        break label865;
      }
      localObject1 = paramPublisherInfo.rpt_interst_name.get();
    }
    label651:
    Object localObject2;
    JSONObject localJSONObject2;
    JSONArray localJSONArray;
    for (;;)
    {
      if (localObject1 != null)
      {
        localObject2 = new ArrayList();
        localJSONObject2 = new JSONObject();
        localJSONArray = new JSONArray();
        localObject1 = ((List)localObject1).iterator();
        for (;;)
        {
          if (((Iterator)localObject1).hasNext())
          {
            String str = ((ByteStringMicro)((Iterator)localObject1).next()).toStringUtf8();
            ((ArrayList)localObject2).add(str);
            localJSONArray.put(str);
            continue;
            i = 0;
            break;
            label737:
            i = 0;
            break label66;
            label743:
            i = 0;
            break label91;
            label749:
            i = 0;
            break label116;
            label755:
            i = 0;
            break label141;
            label761:
            localObject1 = "";
            break label165;
            label768:
            localObject1 = "";
            break label188;
            label775:
            i = 0;
            break label212;
            label781:
            i = 0;
            break label237;
            label787:
            l1 = 0L;
            break label262;
            label793:
            localObject1 = "";
            break label289;
            label800:
            i = 0;
            break label313;
            label806:
            i = 0;
            break label338;
            label812:
            i = 0;
            break label363;
            label818:
            localObject1 = "";
            break label387;
            label825:
            i = 0;
            break label411;
            label831:
            i = 0;
            break label436;
            label837:
            localObject1 = null;
            break label496;
            label842:
            localStrangerInfo.isNewVisitor = true;
            break label527;
            label850:
            paramPublisherInfo = null;
            break label548;
            label855:
            localObject1 = null;
            break label602;
            label860:
            localObject1 = null;
            break label628;
            label865:
            localObject1 = null;
            break label651;
          }
        }
        localStrangerInfo.interestNames = ((ArrayList)localObject2);
      }
    }
    try
    {
      localJSONObject2.put("interestNames", localJSONArray);
      localStrangerInfo.interestNameStr = localJSONObject2.toString();
      localObject1 = localJSONObject1;
      if (paramPublisherInfo.rpt_interst_type.has()) {
        localObject1 = paramPublisherInfo.rpt_interst_type.get();
      }
      if (localObject1 != null)
      {
        paramPublisherInfo = new ArrayList();
        localJSONObject1 = new JSONObject();
        localObject2 = new JSONArray();
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          i = ((Integer)((Iterator)localObject1).next()).intValue();
          paramPublisherInfo.add(Integer.valueOf(i));
          ((JSONArray)localObject2).put(i);
        }
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        if (QLog.isDevelopLevel()) {
          localJSONException.printStackTrace();
        }
      }
      localStrangerInfo.interestTypes = paramPublisherInfo;
    }
    try
    {
      localJSONObject1.put("interestTypes", localObject2);
      localStrangerInfo.interestTypeStr = localJSONObject1.toString();
      label1033:
      if (localStrangerInfo.recentVisitorTime > 0)
      {
        paramPublisherInfo = TimeFormatterUtils.a(localStrangerInfo.recentVisitorTime * 1000L, true, "yyyy-MM-dd");
        localStrangerInfo.timeStr = paramPublisherInfo;
        return localStrangerInfo;
      }
    }
    catch (JSONException paramPublisherInfo)
    {
      for (;;)
      {
        if (QLog.isDevelopLevel())
        {
          paramPublisherInfo.printStackTrace();
          continue;
          paramPublisherInfo = "";
        }
      }
    }
  }
  
  protected void postRead()
  {
    super.postRead();
    if (this.recentVisitorTime > 0) {
      this.timeStr = TimeFormatterUtils.a(this.recentVisitorTime * 1000L, true, "yyyy-MM-dd");
    }
    int i;
    if (!TextUtils.isEmpty(this.interestNameStr)) {
      try
      {
        JSONArray localJSONArray1 = new JSONObject(this.interestNameStr).getJSONArray("interestNames");
        if (localJSONArray1 != null)
        {
          i = 0;
          while (i < localJSONArray1.length())
          {
            String str = localJSONArray1.getString(i);
            if (!TextUtils.isEmpty(str)) {
              this.interestNames.add(str);
            }
            i += 1;
          }
        }
        if (TextUtils.isEmpty(this.interestTypeStr)) {
          return;
        }
      }
      catch (JSONException localJSONException1)
      {
        if (QLog.isDevelopLevel()) {
          localJSONException1.printStackTrace();
        }
      }
    }
    try
    {
      JSONArray localJSONArray2 = new JSONObject(this.interestTypeStr).getJSONArray("interestTypes");
      if (localJSONArray2 != null)
      {
        i = 0;
        while (i < localJSONArray2.length())
        {
          this.interestTypes.add(Integer.valueOf(localJSONArray2.getInt(i)));
          i += 1;
        }
      }
      return;
    }
    catch (JSONException localJSONException2)
    {
      if (QLog.isDevelopLevel()) {
        localJSONException2.printStackTrace();
      }
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    for (Class localClass = getClass(); localClass != Entity.class; localClass = localClass.getSuperclass())
    {
      Field[] arrayOfField = localClass.getDeclaredFields();
      int j = arrayOfField.length;
      int i = 0;
      if (i < j)
      {
        Object localObject = arrayOfField[i];
        if (Modifier.isStatic(((Field)localObject).getModifiers())) {}
        for (;;)
        {
          i += 1;
          break;
          if (!((Field)localObject).isAccessible()) {
            ((Field)localObject).setAccessible(true);
          }
          String str = ((Field)localObject).getName();
          try
          {
            localObject = ((Field)localObject).get(this);
            localStringBuilder.append(',');
            localStringBuilder.append(str);
            localStringBuilder.append('=');
            localStringBuilder.append(localObject);
          }
          catch (Exception localException) {}
        }
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\StrangerInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */