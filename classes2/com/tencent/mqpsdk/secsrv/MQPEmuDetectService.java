package com.tencent.mqpsdk.secsrv;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Xml;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mqpsdk.MQPSecServiceManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;

public class MQPEmuDetectService
{
  public static final String a = "emu_detect_config";
  public static final String b = "emu_detect_result";
  private MQPSecServiceManager jdField_a_of_type_ComTencentMqpsdkMQPSecServiceManager;
  private MQPEmuDetectService.IEmuDetectResultListener jdField_a_of_type_ComTencentMqpsdkSecsrvMQPEmuDetectService$IEmuDetectResultListener;
  
  public MQPEmuDetectService(MQPSecServiceManager paramMQPSecServiceManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMqpsdkMQPSecServiceManager = paramMQPSecServiceManager;
  }
  
  private boolean a(String paramString)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    Object localObject1;
    int i;
    Object localObject2;
    int j;
    int k;
    Object localObject3;
    if (TextUtils.isEmpty(paramString))
    {
      paramString = new HashMap();
      paramString.put("processx", "com.bluestacks.accelerometerui;com.bluestacks.BstCommandProcessor;com.bluestacks.bstfolder");
      if ((Build.BRAND.equals("generic")) && (Build.DEVICE.equals("generic"))) {
        bool1 = true;
      }
      do
      {
        do
        {
          do
          {
            return bool1;
            paramString = (String)paramString.get("processx");
            bool1 = bool2;
          } while (TextUtils.isEmpty(paramString));
          paramString = paramString.split(";");
          bool1 = bool2;
        } while (this.jdField_a_of_type_ComTencentMqpsdkMQPSecServiceManager == null);
        localObject1 = this.jdField_a_of_type_ComTencentMqpsdkMQPSecServiceManager.a;
        bool1 = bool2;
      } while (localObject1 == null);
      localObject1 = ((Context)localObject1).getPackageManager().getInstalledPackages(0);
      bool1 = false;
      i = 0;
      if (i < ((List)localObject1).size())
      {
        localObject2 = (PackageInfo)((List)localObject1).get(i);
        j = 0;
        for (;;)
        {
          bool2 = bool1;
          if (j < paramString.length)
          {
            if (((PackageInfo)localObject2).packageName.equals(paramString[j]))
            {
              k = ((PackageInfo)localObject2).applicationInfo.flags;
              localObject3 = ((PackageInfo)localObject2).applicationInfo;
              if ((k & 0x1) > 0) {
                bool2 = true;
              }
            }
          }
          else
          {
            i += 1;
            bool1 = bool2;
            break;
          }
          j += 1;
        }
      }
    }
    else
    {
      localObject1 = new HashMap();
      bool2 = bool1;
    }
    for (;;)
    {
      int m;
      try
      {
        localObject2 = Xml.newPullParser();
        bool2 = bool1;
        ((XmlPullParser)localObject2).setInput(new StringReader(paramString));
        bool2 = bool1;
        i6 = ((XmlPullParser)localObject2).getEventType();
        k = 0;
        j = 0;
        i = 0;
        m = 0;
        i1 = 0;
        n = 0;
        i2 = 0;
        bool1 = false;
        bool2 = bool1;
        if (i6 == 1) {
          break label2474;
        }
        i4 = i2;
        i3 = m;
        switch (i6)
        {
        default: 
          i3 = m;
          i4 = i2;
        case 1: 
          i5 = i1;
          i6 = n;
          m = i3;
          i2 = i;
          i1 = j;
          n = k;
          k = i6;
          j = i5;
          i = i4;
          if (bool1) {
            bool2 = bool1;
          }
          break;
        }
      }
      catch (Exception paramString)
      {
        int i6;
        Object localObject4;
        Object localObject6;
        Object localObject5;
        paramString.printStackTrace();
        return bool2;
      }
      try
      {
        ((Map)localObject1).clear();
        bool2 = bool1;
      }
      catch (Exception paramString)
      {
        continue;
      }
      bool2 = bool1;
      ((XmlPullParser)localObject2).getName();
      int i3 = k;
      int i4 = j;
      int i5 = i;
      i = i2;
      j = i1;
      k = n;
      int n = i3;
      int i1 = i4;
      int i2 = i5;
      continue;
      bool2 = bool1;
      paramString = ((XmlPullParser)localObject2).getName();
      bool2 = bool1;
      if (paramString.equals("emulatordetect"))
      {
        i3 = k;
        i4 = j;
        i5 = i;
        i = i2;
        j = i1;
        k = n;
        n = i3;
        i1 = i4;
        i2 = i5;
      }
      else
      {
        bool2 = bool1;
        if (paramString.equals("emulatorapn"))
        {
          i = i2;
          i2 = k;
          i3 = j;
          i4 = 1;
          j = i1;
          k = n;
          n = i2;
          i1 = i3;
          i2 = i4;
        }
        else
        {
          bool2 = bool1;
          if (paramString.equals("emulatordrivers"))
          {
            j = i2;
            i3 = k;
            i4 = 1;
            i2 = i;
            i = j;
            j = i1;
            k = n;
            n = i3;
            i1 = i4;
          }
          else
          {
            bool2 = bool1;
            if (paramString.equals("emulatorfiles"))
            {
              k = i2;
              i3 = i1;
              i4 = 1;
              i1 = j;
              i2 = i;
              i = k;
              j = i3;
              k = n;
              n = i4;
            }
            else
            {
              bool2 = bool1;
              if (paramString.equals("emulatorphonestate"))
              {
                m = i2;
                i3 = i1;
                i4 = n;
                i5 = 1;
                n = k;
                i1 = j;
                i2 = i;
                i = m;
                j = i3;
                k = i4;
                m = i5;
              }
              else
              {
                bool2 = bool1;
                if (paramString.equals("emulatorcpu"))
                {
                  i3 = i2;
                  i4 = i1;
                  i5 = 1;
                  n = k;
                  i1 = j;
                  i2 = i;
                  i = i3;
                  j = i4;
                  k = i5;
                }
                else
                {
                  bool2 = bool1;
                  if (paramString.equals("emulatorhardware"))
                  {
                    i4 = i2;
                    i5 = 1;
                    i1 = k;
                    i2 = j;
                    i3 = i;
                    i = i4;
                    j = i5;
                    k = n;
                    n = i1;
                    i1 = i2;
                    i2 = i3;
                  }
                  else
                  {
                    bool2 = bool1;
                    if (paramString.equals("emulatorprocess"))
                    {
                      i5 = 1;
                      i2 = k;
                      i3 = j;
                      i4 = i;
                      i = i5;
                      j = i1;
                      k = n;
                      n = i2;
                      i1 = i3;
                      i2 = i4;
                    }
                    else
                    {
                      bool2 = bool1;
                      localObject3 = ((XmlPullParser)localObject2).getAttributeValue(0);
                      i4 = i2;
                      i3 = m;
                      bool2 = bool1;
                      if (((String)localObject3).length() != 0)
                      {
                        bool2 = bool1;
                        ((Map)localObject1).put(paramString, localObject3);
                        i3 = k;
                        i4 = j;
                        i5 = i;
                        i = i2;
                        j = i1;
                        k = n;
                        n = i3;
                        i1 = i4;
                        i2 = i5;
                        continue;
                        bool2 = bool1;
                        paramString = ((XmlPullParser)localObject2).getName();
                        if (1 == i)
                        {
                          bool2 = bool1;
                          if (paramString.equals("emulatorapn"))
                          {
                            bool2 = bool1;
                            paramString = (String)((Map)localObject1).get("filepath");
                            bool2 = bool1;
                            localObject3 = (String)((Map)localObject1).get("apnx");
                            bool2 = bool1;
                            if (TextUtils.isEmpty(paramString)) {
                              break label2468;
                            }
                            bool2 = bool1;
                            if (TextUtils.isEmpty((CharSequence)localObject3)) {
                              break label2468;
                            }
                            bool2 = bool1;
                            if (a(paramString, ((String)localObject3).split(";"))) {
                              break label2515;
                            }
                            bool1 = true;
                            break label2477;
                          }
                        }
                        boolean bool3;
                        if (1 == j)
                        {
                          bool2 = bool1;
                          if (paramString.equals("emulatordrivers"))
                          {
                            bool2 = bool1;
                            paramString = (String)((Map)localObject1).get("filepath");
                            bool2 = bool1;
                            localObject3 = (String)((Map)localObject1).get("serialportname");
                            bool2 = bool1;
                            localObject4 = (String)((Map)localObject1).get("driverx");
                            bool2 = bool1;
                            bool3 = bool1;
                            if (TextUtils.isEmpty(paramString)) {
                              break label2521;
                            }
                            bool2 = bool1;
                            bool3 = bool1;
                            if (TextUtils.isEmpty((CharSequence)localObject3)) {
                              break label2521;
                            }
                            bool2 = bool1;
                            bool3 = bool1;
                            if (TextUtils.isEmpty((CharSequence)localObject4)) {
                              break label2521;
                            }
                            bool2 = bool1;
                            localObject4 = ((String)localObject4).split(";");
                            bool2 = bool1;
                            bool3 = bool1;
                            if (!new File((String)localObject3).exists()) {
                              break label2521;
                            }
                            bool2 = bool1;
                            bool3 = a(paramString, (String[])localObject4);
                            break label2521;
                          }
                        }
                        if (1 == k)
                        {
                          bool2 = bool1;
                          if (paramString.equals("emulatorfiles"))
                          {
                            bool2 = bool1;
                            paramString = (String)((Map)localObject1).get("filex");
                            bool2 = bool1;
                            bool3 = bool1;
                            if (TextUtils.isEmpty(paramString)) {
                              break label2563;
                            }
                            bool2 = bool1;
                            paramString = paramString.split(";");
                            bool2 = bool1;
                            i3 = paramString.length;
                            k = 0;
                            bool3 = bool1;
                            if (k >= i3) {
                              break label2563;
                            }
                            bool2 = bool1;
                            if (!new File(paramString[k]).exists()) {
                              break label2605;
                            }
                            bool3 = true;
                            break label2563;
                          }
                        }
                        boolean bool4;
                        if (1 == m)
                        {
                          bool2 = bool1;
                          if (paramString.equals("emulatorphonestate"))
                          {
                            i3 = 0;
                            i4 = i2;
                            bool2 = bool1;
                            if (this.jdField_a_of_type_ComTencentMqpsdkMQPSecServiceManager == null) {
                              continue;
                            }
                            bool2 = bool1;
                            localObject6 = this.jdField_a_of_type_ComTencentMqpsdkMQPSecServiceManager.a;
                            bool4 = bool1;
                            if (localObject6 == null) {
                              break label2614;
                            }
                            bool2 = bool1;
                            paramString = (String)((Map)localObject1).get("emulatorcountry");
                            bool2 = bool1;
                            localObject3 = (String)((Map)localObject1).get("phonenumberx");
                            bool2 = bool1;
                            bool4 = bool1;
                            if (TextUtils.isEmpty(paramString)) {
                              break label2614;
                            }
                            bool2 = bool1;
                            bool4 = bool1;
                            if (TextUtils.isEmpty((CharSequence)localObject3)) {
                              break label2614;
                            }
                            bool2 = bool1;
                            localObject3 = ((String)localObject3).split(";");
                            bool2 = bool1;
                            localObject4 = (String)((Map)localObject1).get("IMSI");
                            bool2 = bool1;
                            localObject5 = (String)((Map)localObject1).get("NetOper");
                            bool2 = bool1;
                            localObject6 = (TelephonyManager)((Context)localObject6).getSystemService("phone");
                            bool4 = bool1;
                            if (localObject6 == null) {
                              break label2614;
                            }
                            bool3 = bool1;
                            bool2 = bool1;
                            if (paramString.equals(((TelephonyManager)localObject6).getSimCountryIso()))
                            {
                              bool2 = bool1;
                              paramString = ((TelephonyManager)localObject6).getLine1Number();
                              bool2 = bool1;
                              i3 = localObject3.length;
                              m = 0;
                              bool3 = bool1;
                              if (m < i3)
                              {
                                bool2 = bool1;
                                if (!localObject3[m].equals(paramString)) {
                                  break label2664;
                                }
                                bool3 = true;
                              }
                            }
                            bool4 = bool3;
                            if (bool3) {
                              break label2614;
                            }
                            bool1 = bool3;
                            if (localObject4 != null)
                            {
                              bool1 = bool3;
                              bool2 = bool3;
                              if (((String)localObject4).equals(((TelephonyManager)localObject6).getSubscriberId())) {
                                bool1 = true;
                              }
                            }
                            bool4 = bool1;
                            if (localObject5 == null) {
                              break label2614;
                            }
                            bool2 = bool1;
                            bool4 = bool1;
                            if (!((String)localObject5).equalsIgnoreCase(((TelephonyManager)localObject6).getNetworkOperatorName())) {
                              break label2614;
                            }
                            bool4 = true;
                            break label2614;
                          }
                        }
                        if (1 == n)
                        {
                          bool2 = bool1;
                          if (paramString.equals("emulatorcpu"))
                          {
                            bool2 = bool1;
                            paramString = (String)((Map)localObject1).get("filepath");
                            bool2 = bool1;
                            localObject3 = (String)((Map)localObject1).get("cpux");
                            bool2 = bool1;
                            bool3 = bool1;
                            if (TextUtils.isEmpty(paramString)) {
                              break label2673;
                            }
                            bool2 = bool1;
                            bool3 = bool1;
                            if (TextUtils.isEmpty((CharSequence)localObject3)) {
                              break label2673;
                            }
                            bool2 = bool1;
                            bool3 = a(paramString, ((String)localObject3).split(";"));
                            break label2673;
                          }
                        }
                        if (1 == i1)
                        {
                          bool2 = bool1;
                          if (paramString.equals("emulatorhardware"))
                          {
                            bool2 = bool1;
                            localObject5 = (String)((Map)localObject1).get("brandx");
                            bool2 = bool1;
                            paramString = (String)((Map)localObject1).get("model");
                            bool2 = bool1;
                            localObject3 = (String)((Map)localObject1).get("product");
                            bool2 = bool1;
                            localObject4 = (String)((Map)localObject1).get("hardward");
                            bool2 = bool1;
                            localObject5 = ((String)localObject5).split(";");
                            bool2 = bool1;
                            if (Build.BRAND.equals("generic"))
                            {
                              bool2 = bool1;
                              if (Build.DEVICE.equals("generic")) {
                                break label2715;
                              }
                            }
                            if (paramString != null)
                            {
                              bool2 = bool1;
                              if (Build.MODEL.equals(paramString)) {
                                break label2715;
                              }
                            }
                            if (localObject3 != null)
                            {
                              bool2 = bool1;
                              if (Build.PRODUCT.equals(localObject3)) {
                                break label2715;
                              }
                            }
                            if (localObject4 != null)
                            {
                              bool2 = bool1;
                              if (Build.HARDWARE.equals(localObject4)) {
                                break label2715;
                              }
                            }
                            bool2 = bool1;
                            paramString = Build.BRAND;
                            i1 = 0;
                            bool2 = bool1;
                          }
                        }
                        try
                        {
                          if (i1 >= localObject5.length) {
                            break label2718;
                          }
                          bool2 = localObject5[i1].equals(paramString);
                          if (bool2) {
                            bool1 = true;
                          }
                          i1 += 1;
                        }
                        catch (Exception paramString)
                        {
                          bool2 = bool1;
                          continue;
                          continue;
                          i2 = i1;
                          i3 = n;
                          n = k;
                          i1 = j;
                          j = 0;
                          i4 = i;
                          i = j;
                          j = i2;
                          k = i3;
                          i2 = i4;
                        }
                        i4 = i2;
                        i3 = m;
                        if (1 == i2)
                        {
                          i4 = i2;
                          i3 = m;
                          bool2 = bool1;
                          if (paramString.equals("emulatorprocess"))
                          {
                            i2 = 0;
                            i4 = i2;
                            i3 = m;
                            if (localObject1 != null)
                            {
                              bool2 = bool1;
                              paramString = (String)((Map)localObject1).get("processx");
                              i4 = i2;
                              i3 = m;
                              bool2 = bool1;
                              if (!TextUtils.isEmpty(paramString))
                              {
                                bool2 = bool1;
                                paramString = paramString.split(";");
                                i4 = i2;
                                i3 = m;
                                bool2 = bool1;
                                if (this.jdField_a_of_type_ComTencentMqpsdkMQPSecServiceManager != null)
                                {
                                  bool2 = bool1;
                                  localObject3 = this.jdField_a_of_type_ComTencentMqpsdkMQPSecServiceManager.a;
                                  i4 = i2;
                                  i3 = m;
                                  if (localObject3 != null)
                                  {
                                    bool2 = bool1;
                                    localObject3 = ((Context)localObject3).getPackageManager().getInstalledPackages(0);
                                    i2 = 0;
                                    bool2 = bool1;
                                    if (i2 < ((List)localObject3).size())
                                    {
                                      bool2 = bool1;
                                      localObject4 = (PackageInfo)((List)localObject3).get(i2);
                                      i3 = 0;
                                      bool2 = bool1;
                                      if (i3 < paramString.length)
                                      {
                                        bool2 = bool1;
                                        if (((PackageInfo)localObject4).packageName.equals(paramString[i3]))
                                        {
                                          bool2 = bool1;
                                          i4 = ((PackageInfo)localObject4).applicationInfo.flags;
                                          bool2 = bool1;
                                          localObject5 = ((PackageInfo)localObject4).applicationInfo;
                                          if ((i4 & 0x1) > 0)
                                          {
                                            bool1 = true;
                                            i2 += 1;
                                            continue;
                                          }
                                        }
                                        i3 += 1;
                                        continue;
                                        bool2 = bool1;
                                        i6 = ((XmlPullParser)localObject2).next();
                                        i3 = n;
                                        i4 = i1;
                                        i5 = i2;
                                        i2 = i;
                                        i1 = j;
                                        n = k;
                                        k = i3;
                                        j = i4;
                                        i = i5;
                                        continue;
                                      }
                                    }
                                    continue;
                                    label2468:
                                    break label2477;
                                    return bool1;
                                    label2474:
                                    return bool2;
                                    for (;;)
                                    {
                                      label2477:
                                      i = i2;
                                      i2 = i1;
                                      i3 = n;
                                      n = k;
                                      i1 = j;
                                      i4 = 0;
                                      j = i2;
                                      k = i3;
                                      i2 = i4;
                                      break;
                                      label2515:
                                      bool1 = false;
                                    }
                                    label2521:
                                    j = i2;
                                    i3 = k;
                                    i4 = 0;
                                    i2 = i;
                                    i = j;
                                    j = i1;
                                    k = n;
                                    bool1 = bool3;
                                    n = i3;
                                    i1 = i4;
                                    continue;
                                    label2563:
                                    k = i2;
                                    i3 = i1;
                                    i4 = 0;
                                    i1 = j;
                                    i2 = i;
                                    i = k;
                                    j = i3;
                                    k = n;
                                    bool1 = bool3;
                                    n = i4;
                                    continue;
                                    label2605:
                                    k += 1;
                                    continue;
                                    label2614:
                                    m = i2;
                                    i3 = i1;
                                    i4 = n;
                                    i5 = 0;
                                    n = k;
                                    i1 = j;
                                    i2 = i;
                                    i = m;
                                    j = i3;
                                    k = i4;
                                    bool1 = bool4;
                                    m = i5;
                                    continue;
                                    label2664:
                                    m += 1;
                                    continue;
                                    label2673:
                                    i3 = i2;
                                    i4 = i1;
                                    i5 = 0;
                                    n = k;
                                    i1 = j;
                                    i2 = i;
                                    i = i3;
                                    j = i4;
                                    k = i5;
                                    bool1 = bool3;
                                    continue;
                                    label2715:
                                    bool2 = true;
                                    label2718:
                                    i4 = i2;
                                    i5 = 0;
                                    i2 = n;
                                    bool1 = bool2;
                                    n = k;
                                    i1 = j;
                                    i3 = i;
                                    i = i4;
                                    j = i5;
                                    k = i2;
                                    i2 = i3;
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  private boolean a(String paramString, String[] paramArrayOfString)
  {
    boolean bool2 = false;
    Object localObject = new File(paramString);
    boolean bool1 = bool2;
    int i;
    if (((File)localObject).exists())
    {
      bool1 = bool2;
      if (((File)localObject).canRead())
      {
        i = (int)((File)localObject).length();
        if (i == 0) {
          break label123;
        }
        paramString = new byte[i];
      }
    }
    try
    {
      localObject = new FileInputStream((File)localObject);
      i = ((InputStream)localObject).read(paramString);
      ((InputStream)localObject).close();
      paramString = new String(paramString, 0, i);
      int j = paramArrayOfString.length;
      i = 0;
      for (;;)
      {
        bool1 = bool2;
        if (i < j)
        {
          int k = paramString.indexOf(paramArrayOfString[i]);
          if (k != -1) {
            bool1 = true;
          }
        }
        else
        {
          return bool1;
          label123:
          paramString = new byte['Ѐ'];
          break;
        }
        i += 1;
      }
      return false;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void a(MQPEmuDetectService.IEmuDetectResultListener paramIEmuDetectResultListener)
  {
    this.jdField_a_of_type_ComTencentMqpsdkSecsrvMQPEmuDetectService$IEmuDetectResultListener = paramIEmuDetectResultListener;
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMqpsdkSecsrvMQPEmuDetectService$IEmuDetectResultListener == null) {
      return;
    }
    localObject = null;
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      paramString = (String)localObject;
      if (localJSONObject.has("emu_detect_config")) {
        paramString = localJSONObject.getString("emu_detect_config");
      }
    }
    catch (Exception paramString)
    {
      try
      {
        boolean bool;
        paramString.put("emu_detect_result", bool);
        this.jdField_a_of_type_ComTencentMqpsdkSecsrvMQPEmuDetectService$IEmuDetectResultListener.a(paramString.toString());
        return;
        paramString = paramString;
        paramString.printStackTrace();
        paramString = (String)localObject;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
    }
    bool = a(paramString);
    paramString = new JSONObject();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mqpsdk\secsrv\MQPEmuDetectService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */