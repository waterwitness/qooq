package com.tencent.mobileqq.emoticon;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class EmotionJsonUtils
{
  public static final String a;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = EmotionJsonUtils.class.getSimpleName();
  }
  
  public static String a(QQAppInterface paramQQAppInterface, EmoticonPackage paramEmoticonPackage, int paramInt, byte[] paramArrayOfByte, ArrayList paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "parseSmallJson: parseSmallJson start");
    }
    if (paramQQAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "parseSmallJson: app is null");
      }
      return "app is null";
    }
    if (paramEmoticonPackage == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "parseSmallJson: ep is null");
      }
      return "ep is null";
    }
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length < 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "parseSmallJson: data is null");
      }
      return "json data is null";
    }
    if (paramArrayList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "parseSmallJson: params is null");
      }
      return "params is null";
    }
    EmoticonManager localEmoticonManager = (EmoticonManager)paramQQAppInterface.getManager(13);
    Object localObject2;
    Object localObject1;
    label386:
    String str2;
    String str1;
    try
    {
      paramArrayOfByte = new JSONObject(new String(paramArrayOfByte, "utf-8"));
      long l = paramArrayOfByte.getLong("timestamp");
      paramQQAppInterface = paramArrayOfByte.getJSONObject("data");
      localObject2 = paramQQAppInterface.getJSONArray("baseInfo");
      localObject1 = paramQQAppInterface.getJSONArray("operationInfo");
      if ((localObject2 == null) || (localObject1 == null)) {
        break label854;
      }
      localObject2 = (JSONObject)((JSONArray)localObject2).get(0);
      localObject1 = (JSONObject)((JSONArray)localObject1).get(0);
      localObject2 = ((JSONObject)localObject2).getString("name");
      j = 0;
      i = 6;
      if (paramArrayOfByte.has("type")) {
        i = paramArrayOfByte.getInt("type");
      }
      if (((JSONObject)localObject1).has("feeType")) {
        j = ((JSONObject)localObject1).getInt("feeType");
      }
      paramEmoticonPackage.localVersion = ((int)(l / 1000L));
      paramEmoticonPackage.name = ((String)localObject2);
      paramEmoticonPackage.mark = "";
      paramEmoticonPackage.type = i;
      paramEmoticonPackage.mobileFeetype = j;
      paramEmoticonPackage.jobType = 4;
      if ((paramEmoticonPackage.mobileFeetype != 1) && ((paramEmoticonPackage.epId == null) || (!"10278".equals(paramEmoticonPackage.epId)))) {
        break label531;
      }
      paramEmoticonPackage.wordingId = 1L;
    }
    catch (JSONException paramQQAppInterface)
    {
      for (;;)
      {
        int m;
        paramQQAppInterface.printStackTrace();
        paramArrayOfByte = paramQQAppInterface.toString();
        QLog.e(jdField_a_of_type_JavaLangString, 1, "parseSmallJson: fail 01 RESULT_CODE_JSON_PARSE_FAIL  ep=" + paramEmoticonPackage.epId + " exception=" + paramQQAppInterface.toString());
        return paramArrayOfByte;
        paramEmoticonPackage.wordingId = -1L;
      }
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
      paramArrayOfByte = paramQQAppInterface.toString();
      QLog.e(jdField_a_of_type_JavaLangString, 1, "parseSmallJson: fail 02 RESULT_CODE_JSON_PARSE_FAIL  ep=" + paramEmoticonPackage.epId + " exception=" + paramQQAppInterface.toString());
      return paramArrayOfByte;
    }
    localEmoticonManager.a(paramEmoticonPackage);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "parseSmallJson: ep = " + paramEmoticonPackage);
    }
    paramArrayOfByte = paramQQAppInterface.getJSONArray("itemInfo");
    m = paramArrayOfByte.length();
    int i = 1;
    int j = 0;
    if (j < m)
    {
      paramQQAppInterface = paramArrayOfByte.getJSONObject(j);
      localObject1 = paramQQAppInterface.getString("id");
      localObject2 = paramQQAppInterface.getString("name");
      str2 = paramQQAppInterface.getString("character");
      str1 = paramEmoticonPackage.epId;
      paramQQAppInterface = localEmoticonManager.a(str1, (String)localObject1);
      if (paramQQAppInterface == null)
      {
        if (paramInt == EmojiManager.f) {
          break label851;
        }
        paramQQAppInterface = new Emoticon();
        paramQQAppInterface.eId = ((String)localObject1);
        paramQQAppInterface.epId = str1;
        paramQQAppInterface.name = ((String)localObject2);
        paramQQAppInterface.character = str2;
        paramQQAppInterface.jobType = 3;
        i = 1;
      }
    }
    for (;;)
    {
      if (paramQQAppInterface == null)
      {
        if (!QLog.isColorLevel()) {
          break label858;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, "emoticon json update, cannot find emoticon from epId: " + str1);
        break label858;
        label531:
        paramArrayOfByte = localEmoticonManager.b(paramEmoticonPackage.epId);
        if (paramArrayOfByte != null)
        {
          paramEmoticonPackage.wordingId = paramArrayOfByte.wordingId;
          break;
        }
        if ((((String)localObject1).equals(paramQQAppInterface.eId)) && (str1.equals(paramQQAppInterface.epId)) && (((String)localObject2).equals(paramQQAppInterface.name))) {
          break label873;
        }
        paramQQAppInterface.eId = ((String)localObject1);
        paramQQAppInterface.epId = str1;
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          paramQQAppInterface.name = ((String)localObject2);
        }
        if (TextUtils.isEmpty(str2)) {
          break label867;
        }
        paramQQAppInterface.character = str2;
        break label867;
      }
      int k = 0;
      if (EmoticonUtils.a(paramEmoticonPackage)) {
        k = 1;
      }
      paramQQAppInterface.isSound = paramEmoticonPackage.hasSound;
      paramArrayList.add(paramQQAppInterface);
      if ((i != 0) && (k == 0)) {
        localEmoticonManager.a(paramQQAppInterface);
      }
      if (QLog.isColorLevel())
      {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "parseSmallJson :emoticon eId[" + (String)localObject1 + "]eName[" + (String)localObject2 + "]");
        break label858;
        return null;
        label851:
        continue;
        label854:
        return "parseSmallJson:json data is error";
      }
      label858:
      j += 1;
      break label386;
      label867:
      i = 1;
      continue;
      label873:
      i = 0;
    }
  }
  
  public static String a(QQAppInterface paramQQAppInterface, EmoticonPackage paramEmoticonPackage, int paramInt, byte[] paramArrayOfByte, ArrayList paramArrayList, ReqInfo paramReqInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "parseJson : parseJson start");
    }
    if (paramQQAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "parseJson : ap is null");
      }
      return "app is null";
    }
    if (paramEmoticonPackage == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "parseJson : ep is null");
      }
      return "ep is null";
    }
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length < 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "parseJson : json data is null");
      }
      return "json data is null";
    }
    if ((paramArrayList == null) || (paramReqInfo == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "parseJson : params is null");
      }
      return "params is null";
    }
    EmoticonManager localEmoticonManager = (EmoticonManager)paramQQAppInterface.getManager(13);
    String str1;
    Object localObject1;
    int j;
    label200:
    int k;
    label219:
    int m;
    label238:
    int n;
    label257:
    Object localObject2;
    boolean bool;
    int i;
    try
    {
      paramArrayOfByte = new JSONObject(new String(paramArrayOfByte, "utf-8"));
      str1 = paramArrayOfByte.getString("id");
      localObject1 = paramArrayOfByte.getString("name");
      if (!paramArrayOfByte.has("mark")) {
        break label1792;
      }
      paramQQAppInterface = paramArrayOfByte.getString("mark");
      if (!paramArrayOfByte.has("type")) {
        break label1786;
      }
      j = paramArrayOfByte.getInt("type");
      if (!paramArrayOfByte.has("feetype")) {
        break label1780;
      }
      k = paramArrayOfByte.getInt("feetype");
      if (!paramArrayOfByte.has("rscType")) {
        break label1774;
      }
      m = paramArrayOfByte.getInt("rscType");
      if (!paramArrayOfByte.has("updateTime")) {
        break label1768;
      }
      n = paramArrayOfByte.getInt("updateTime");
      if (!paramArrayOfByte.has("ringtype")) {
        break label1759;
      }
      localObject2 = paramArrayOfByte.getString("ringtype");
      if (!"1".equals(localObject2)) {
        break label1157;
      }
      bool = true;
      i = 1;
      label293:
      if ((!paramArrayOfByte.has("type")) || (1 != j)) {
        break label1753;
      }
      i1 = 3;
      label311:
      i2 = 0;
      if (paramArrayOfByte.has("downloadcount")) {
        i2 = paramArrayOfByte.getInt("downloadcount");
      }
      paramEmoticonPackage.epId = str1;
      paramEmoticonPackage.name = ((String)localObject1);
      paramEmoticonPackage.mark = paramQQAppInterface;
      paramEmoticonPackage.type = j;
      paramEmoticonPackage.mobileFeetype = k;
      paramEmoticonPackage.hasSound = bool;
      paramEmoticonPackage.subType = i;
      paramEmoticonPackage.downloadCount = i2;
      paramEmoticonPackage.jobType = i1;
      if ((paramArrayOfByte.has("type")) && (4 == j)) {
        paramEmoticonPackage.jobType = 5;
      }
      paramEmoticonPackage.rscType = m;
      if (paramInt != EmojiManager.f) {
        paramEmoticonPackage.localVersion = n;
      }
      paramQQAppInterface = localEmoticonManager.b(str1);
      if (paramQQAppInterface != null)
      {
        paramEmoticonPackage.status = paramQQAppInterface.status;
        paramEmoticonPackage.valid = paramQQAppInterface.valid;
      }
      if ((paramEmoticonPackage.mobileFeetype != 1) && ((str1 == null) || (!"10278".equals(str1))) && (paramEmoticonPackage.jobType != 1)) {
        break label1192;
      }
      paramEmoticonPackage.wordingId = 1L;
    }
    catch (JSONException paramQQAppInterface)
    {
      for (;;)
      {
        int i2;
        JSONArray localJSONArray;
        paramQQAppInterface.printStackTrace();
        paramArrayOfByte = paramQQAppInterface.toString();
        QLog.e(jdField_a_of_type_JavaLangString, 1, "parseJson: PARSE_EMOTICON_JSON fail 01 RESULT_CODE_JSON_PARSE_FAIL  ep=" + paramEmoticonPackage.epId + " exception=" + paramQQAppInterface.toString());
        return paramArrayOfByte;
        paramEmoticonPackage.wordingId = -1L;
      }
    }
    catch (Exception paramQQAppInterface)
    {
      label489:
      label529:
      paramQQAppInterface.printStackTrace();
      paramArrayOfByte = paramQQAppInterface.toString();
      QLog.d(jdField_a_of_type_JavaLangString, 1, "parseJson: PARSE_EMOTICON_JSON fail 02 RESULT_CODE_JSON_PARSE_FAIL  ep=" + paramEmoticonPackage.epId + " exception=" + paramQQAppInterface.toString());
      return paramArrayOfByte;
    }
    if ((paramArrayOfByte != null) && (paramArrayOfByte.has("operationInfo")))
    {
      paramQQAppInterface = paramArrayOfByte.getJSONArray("operationInfo");
      if ((paramQQAppInterface != null) && (paramQQAppInterface.length() > 0))
      {
        i = 0;
        j = paramQQAppInterface.length();
        if (i < j)
        {
          localObject1 = paramQQAppInterface.getJSONObject(i);
          if ((localObject1 == null) || (!((JSONObject)localObject1).has("platform")) || (!"3".equals(((JSONObject)localObject1).getString("platform")))) {
            break label1325;
          }
          if (((JSONObject)localObject1).has("minVersion"))
          {
            paramQQAppInterface = ((JSONObject)localObject1).getString("minVersion");
            if (!TextUtils.isEmpty(paramQQAppInterface)) {
              paramEmoticonPackage.minQQVersion = paramQQAppInterface;
            }
          }
        }
      }
    }
    if ((paramArrayOfByte != null) && (paramArrayOfByte.has("childEmojiId")))
    {
      paramQQAppInterface = paramArrayOfByte.getString("childEmojiId");
      if (!TextUtils.isEmpty(paramQQAppInterface))
      {
        paramQQAppInterface = paramQQAppInterface.split(",");
        if ((paramQQAppInterface != null) && (paramQQAppInterface.length > 0))
        {
          paramQQAppInterface = paramQQAppInterface[0];
          if (!TextUtils.isEmpty(paramQQAppInterface))
          {
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "parseJson, child magic, id=" + paramQQAppInterface);
            }
            paramEmoticonPackage.childEpId = paramQQAppInterface;
          }
        }
      }
    }
    if ((paramArrayOfByte != null) && (paramArrayOfByte.has("supportSize"))) {
      paramEmoticonPackage.supportSize = paramArrayOfByte.getJSONArray("supportSize").toString();
    }
    if ((paramArrayOfByte != null) && (paramArrayOfByte.has("commDiyText"))) {
      paramEmoticonPackage.businessExtra = paramArrayOfByte.getJSONArray("commDiyText").toString();
    }
    localEmoticonManager.a(paramEmoticonPackage);
    int i1 = localEmoticonManager.a(str1);
    if (EmoticonUtils.a(paramEmoticonPackage))
    {
      bool = true;
      label785:
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "parseJson: ep = " + paramEmoticonPackage + " ,update :" + bool);
      }
      localJSONArray = paramArrayOfByte.getJSONArray("imgs");
      i2 = localJSONArray.length();
      i = 1;
      k = 0;
      j = 0;
      label854:
      if (k >= i2) {
        break label1811;
      }
      paramArrayOfByte = localJSONArray.getJSONObject(k);
      String str2 = paramArrayOfByte.getString("id");
      String str3 = paramArrayOfByte.getString("name");
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "parseJson: emotion.id:" + str2);
      }
      if (paramArrayOfByte.has("wWidthInPhone"))
      {
        m = paramArrayOfByte.getInt("wWidthInPhone");
        label938:
        if (paramArrayOfByte.has("wHeightInPhone"))
        {
          n = paramArrayOfByte.getInt("wHeightInPhone");
          label957:
          if (paramArrayOfByte.has("keywords"))
          {
            paramQQAppInterface = paramArrayOfByte.getJSONArray("keywords");
            if (!TextUtils.isEmpty(str3)) {
              paramQQAppInterface.put(str3);
            }
            paramQQAppInterface = paramQQAppInterface.toString();
            label995:
            if (!paramArrayOfByte.has("diyText")) {
              break label1729;
            }
            paramArrayOfByte = paramArrayOfByte.getJSONArray("diyText");
            if (paramArrayOfByte == null) {
              break label1729;
            }
            paramArrayOfByte = paramArrayOfByte.toString();
            label1022:
            localObject2 = localEmoticonManager.a(str1, str2);
            if (localObject2 != null) {
              break label1365;
            }
            localObject1 = localObject2;
            if (paramInt != EmojiManager.f)
            {
              localObject1 = new Emoticon();
              ((Emoticon)localObject1).eId = str2;
              ((Emoticon)localObject1).epId = str1;
              ((Emoticon)localObject1).name = str3;
              ((Emoticon)localObject1).width = m;
              ((Emoticon)localObject1).height = n;
              ((Emoticon)localObject1).keywords = paramQQAppInterface;
              ((Emoticon)localObject1).businessExtra = paramArrayOfByte;
              i = 1;
            }
          }
          for (;;)
          {
            if (localObject1 != null) {
              break label1525;
            }
            m = j;
            if (!QLog.isColorLevel()) {
              break label1798;
            }
            QLog.d(jdField_a_of_type_JavaLangString, 2, "emoticon json update, cannot find emoticon from epId: " + str1);
            m = j;
            break label1798;
            label1157:
            if ("2".equals(localObject2)) {
              return "qFace are not supported";
            }
            if (!"4".equals(localObject2)) {
              break label1759;
            }
            bool = false;
            i = 4;
            break;
            label1192:
            if (paramQQAppInterface != null)
            {
              paramEmoticonPackage.wordingId = paramQQAppInterface.wordingId;
              break label489;
            }
            label1325:
            i += 1;
            break label529;
            paramQQAppInterface = "[" + str3 + "]";
            break label995;
            label1365:
            if ((!str2.equals(((Emoticon)localObject2).eId)) || (!str1.equals(((Emoticon)localObject2).epId)) || (!str3.equals(((Emoticon)localObject2).name)))
            {
              ((Emoticon)localObject2).eId = str2;
              ((Emoticon)localObject2).epId = str1;
              if (!TextUtils.isEmpty(str3)) {
                ((Emoticon)localObject2).name = str3;
              }
              ((Emoticon)localObject2).width = m;
              ((Emoticon)localObject2).height = n;
              ((Emoticon)localObject2).keywords = paramQQAppInterface;
              ((Emoticon)localObject2).businessExtra = paramArrayOfByte;
              i = 1;
              localObject1 = localObject2;
            }
            else
            {
              i = 0;
              if (!paramQQAppInterface.equals(((Emoticon)localObject2).keywords))
              {
                i = 1;
                ((Emoticon)localObject2).keywords = paramQQAppInterface;
              }
              localObject1 = localObject2;
              if (!paramArrayOfByte.equals(((Emoticon)localObject2).businessExtra))
              {
                i = 1;
                ((Emoticon)localObject2).businessExtra = paramArrayOfByte;
                localObject1 = localObject2;
              }
            }
          }
          label1525:
          if (paramEmoticonPackage.jobType == 0) {
            ((Emoticon)localObject1).jobType = 0;
          }
          for (;;)
          {
            if (TextUtils.isEmpty(((Emoticon)localObject1).encryptKey)) {
              j = 1;
            }
            ((Emoticon)localObject1).isSound = paramEmoticonPackage.hasSound;
            paramArrayList.add(localObject1);
            if (i1 != -1)
            {
              ((Emoticon)localObject1).extensionWidth = i1;
              ((Emoticon)localObject1).extensionHeight = i1;
            }
            if ((i != 0) && (!bool)) {
              localEmoticonManager.a((Emoticon)localObject1);
            }
            m = j;
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d(jdField_a_of_type_JavaLangString, 2, "paseJson: emoticon eId[" + str2 + "]eName[" + str3 + "]");
            m = j;
            break;
            if (paramEmoticonPackage.jobType == 1) {
              return "qFace are not supported";
            }
            if (paramEmoticonPackage.jobType == 3) {
              ((Emoticon)localObject1).jobType = 2;
            } else if (paramEmoticonPackage.jobType == 5) {
              ((Emoticon)localObject1).jobType = 4;
            }
          }
        }
      }
    }
    for (;;)
    {
      label1714:
      paramReqInfo.a = bool;
      return null;
      label1729:
      label1753:
      label1759:
      label1768:
      label1774:
      label1780:
      label1786:
      label1792:
      label1798:
      label1811:
      do
      {
        bool = false;
        break label1714;
        paramArrayOfByte = "";
        break label1022;
        n = 0;
        break label957;
        m = 0;
        break label938;
        bool = false;
        break label785;
        i1 = 0;
        break label311;
        bool = false;
        i = 0;
        break label293;
        n = 0;
        break label257;
        m = 0;
        break label238;
        k = 0;
        break label219;
        j = 0;
        break label200;
        paramQQAppInterface = "";
        break;
        k += 1;
        j = m;
        break label854;
      } while (j != 0);
      bool = true;
    }
  }
  
  public static String a(QQAppInterface paramQQAppInterface, DownloadTask paramDownloadTask, boolean paramBoolean)
  {
    ArrayList localArrayList = null;
    if ((paramQQAppInterface == null) && (paramDownloadTask == null)) {}
    EmoticonPackage localEmoticonPackage;
    do
    {
      return null;
      localObject = paramDownloadTask.a();
      localEmoticonPackage = (EmoticonPackage)((Bundle)localObject).getSerializable("emoticonPackage");
    } while (localEmoticonPackage == null);
    int i = ((Bundle)localObject).getInt("jsonType", EmojiManager.e);
    File localFile = (File)paramDownloadTask.jdField_a_of_type_JavaUtilMap.get(paramDownloadTask.jdField_a_of_type_JavaLangString);
    Object localObject = new ReqInfo();
    paramDownloadTask = localArrayList;
    if (localFile != null)
    {
      if (localFile.exists()) {
        paramDownloadTask = FileUtils.a(localFile);
      }
    }
    else
    {
      localArrayList = new ArrayList();
      if (!paramBoolean) {
        break label164;
      }
    }
    label164:
    for (paramQQAppInterface = a(paramQQAppInterface, localEmoticonPackage, i, paramDownloadTask, localArrayList);; paramQQAppInterface = a(paramQQAppInterface, localEmoticonPackage, i, paramDownloadTask, localArrayList, (ReqInfo)localObject))
    {
      if ((QLog.isColorLevel()) && (paramQQAppInterface != null)) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "handleJsonFileDownload : json parse result = " + paramQQAppInterface);
      }
      return paramQQAppInterface;
      paramDownloadTask = null;
      break;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\emoticon\EmotionJsonUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */