package com.tencent.biz.qrcode;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.qphone.base.util.BaseApplication;
import jae;
import jag;
import jah;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CodeMaskManager
{
  private static final String jdField_a_of_type_JavaLangString = "http://qm.qq.com/cgi-bin/tpl";
  private static final String b;
  private static final int jdField_c_of_type_Int = 1;
  private static final String jdField_c_of_type_JavaLangString = "http://pub.idqqimg.com/qqmobile/qrcode/images/";
  private static final int jdField_d_of_type_Int = 2;
  private static final String jdField_d_of_type_JavaLangString = "qrcode";
  private static final int jdField_e_of_type_Int = 10000;
  private static final String jdField_e_of_type_JavaLangString = "updateTemplate2";
  private static final String f = "lastIndex";
  private static final String g = "tpl_json";
  protected int a;
  public Activity a;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  public Handler a;
  public Thread a;
  protected List a;
  public boolean a;
  protected int b;
  protected List b;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    if (SystemUtil.a())
    {
      jdField_b_of_type_JavaLangString = AppConstants.bj + "qbiz/qrcode/";
      return;
    }
    jdField_b_of_type_JavaLangString = BaseApplicationImpl.getContext().getCacheDir().getAbsolutePath() + "/qbiz/qrcode/";
  }
  
  public CodeMaskManager(Activity paramActivity)
  {
    this(paramActivity, 2);
  }
  
  public CodeMaskManager(Activity paramActivity, int paramInt)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_b_of_type_JavaUtilList = new Vector();
    a(paramInt);
    this.jdField_a_of_type_JavaUtilList = this.jdField_b_of_type_JavaUtilList;
    b(a());
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
  }
  
  private int a()
  {
    try
    {
      Object localObject = this.jdField_a_of_type_AndroidAppActivity.getSharedPreferences("qrcode", 0).getString("tpl_json", null);
      if (localObject == null) {
        return 0;
      }
      localObject = new JSONObject((String)localObject);
      JSONArray localJSONArray = ((JSONObject)localObject).getJSONArray("tpls");
      if (localJSONArray.length() > 0)
      {
        a(localJSONArray);
        int i = ((JSONObject)localObject).getInt("t");
        return i;
      }
    }
    catch (JSONException localJSONException) {}
    return 0;
  }
  
  private int a(int paramInt)
  {
    int i = 0;
    if (paramInt < 1) {
      throw new IllegalArgumentException("qrcode mask build-in list should have at least 1 item");
    }
    if (paramInt == 1) {
      paramInt = i;
    }
    for (;;)
    {
      this.jdField_b_of_type_Int = paramInt;
      return this.jdField_b_of_type_Int;
      if (this.jdField_a_of_type_Int == -1)
      {
        int j = this.jdField_a_of_type_AndroidAppActivity.getSharedPreferences("qrcode", 0).getInt("lastIndex", 0);
        if (j >= 0)
        {
          i = j;
          if (j < paramInt) {}
        }
        else
        {
          i = 0;
        }
        paramInt = i;
      }
      else
      {
        i = (int)(Math.random() * (paramInt - 1));
        paramInt = i;
        if (i >= this.jdField_a_of_type_Int) {
          paramInt = i + 1;
        }
      }
    }
  }
  
  private Bitmap a(String paramString)
  {
    Object localObject2;
    if ((paramString == null) || (paramString.equals(""))) {
      localObject2 = null;
    }
    String str;
    do
    {
      return (Bitmap)localObject2;
      localObject1 = paramString;
      if (!paramString.startsWith("http://")) {
        localObject1 = "http://pub.idqqimg.com/qqmobile/qrcode/images/" + paramString;
      }
      str = AbsDownloader.c((String)localObject1);
      paramString = BitmapFactory.decodeFile(jdField_b_of_type_JavaLangString + str);
      localObject2 = paramString;
    } while (paramString != null);
    Object localObject1 = HttpUtil.a(this.jdField_a_of_type_AndroidAppActivity, MsfSdkUtils.insertMtype("codemask", (String)localObject1), "GET", null, null);
    if (localObject1 != null) {
      paramString = BitmapFactory.decodeByteArray((byte[])localObject1, 0, localObject1.length);
    }
    if (paramString == null) {
      throw new IOException("拉取图片失败");
    }
    a(str, (byte[])localObject1);
    return paramString;
  }
  
  private Bundle a()
  {
    int i = a(this.jdField_b_of_type_JavaUtilList.size());
    return a((Bundle)this.jdField_b_of_type_JavaUtilList.get(i));
  }
  
  private Bundle a(Bundle paramBundle)
  {
    int i;
    if (paramBundle.containsKey("bkgRes"))
    {
      i = paramBundle.getInt("bkgRes");
      paramBundle.remove("bkg");
      if (i == 0) {}
    }
    try
    {
      paramBundle.putParcelable("bkg", BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidAppActivity.getResources(), i));
      if (paramBundle.containsKey("qrbkgRes"))
      {
        i = paramBundle.getInt("qrbkgRes");
        paramBundle.remove("qrbkg");
        if (i == 0) {}
      }
      try
      {
        paramBundle.putParcelable("qrbkg", BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidAppActivity.getResources(), i));
        return (Bundle)paramBundle.clone();
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        for (;;) {}
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError2)
    {
      for (;;) {}
    }
  }
  
  private void a(int paramInt)
  {
    Bundle localBundle = new Bundle();
    if (paramInt == 1)
    {
      localBundle.putInt("qrbkgRes", 2130839558);
      localBundle.putInt("bkgRes", 0);
      localBundle.putInt("nameClr", -16777216);
      localBundle.putInt("tipsClr", -8947849);
      localBundle.putInt("B", 0);
      localBundle.putInt("W", -1);
      localBundle.putParcelable("qrloc", new Rect(126, 156, 413, 443));
      localBundle.putInt("head", 0);
      localBundle.putInt("type", 1);
    }
    for (;;)
    {
      this.jdField_b_of_type_JavaUtilList.add(localBundle);
      return;
      localBundle.putInt("bkgRes", 0);
      localBundle.putInt("nameClr", -16777216);
      localBundle.putInt("tipsClr", -8947849);
      localBundle.putInt("B", -16777216);
      localBundle.putInt("W", 16777215);
      localBundle.putParcelable("qrloc", new Rect(45, 76, 495, 526));
      localBundle.putInt("head", 1);
      localBundle.putInt("type", 1);
    }
  }
  
  private void a(JSONArray paramJSONArray)
  {
    if (this.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_JavaUtilList = new Vector(this.jdField_b_of_type_JavaUtilList);
      int i = 0;
      while (i < paramJSONArray.length())
      {
        try
        {
          JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
          Bundle localBundle = new Bundle();
          if (localJSONObject.has("bkg")) {
            localBundle.putString("bkgUrl", localJSONObject.getString("bkg"));
          }
          localBundle.putInt("nameClr", (int)Long.parseLong(localJSONObject.getString("nameClr"), 16));
          localBundle.putInt("tipsClr", (int)Long.parseLong(localJSONObject.getString("tipsClr"), 16));
          if (localJSONObject.has("qrbkg")) {
            localBundle.putString("qrbkgUrl", localJSONObject.getString("qrbkg"));
          }
          Object localObject;
          int k;
          int m;
          int n;
          int i1;
          if (localJSONObject.has("qrloc"))
          {
            localObject = localJSONObject.getJSONArray("qrloc");
            j = ((JSONArray)localObject).getInt(0);
            k = ((JSONArray)localObject).getInt(1);
            m = ((JSONArray)localObject).getInt(0);
            n = ((JSONArray)localObject).getInt(2);
            i1 = ((JSONArray)localObject).getInt(1);
            localBundle.putParcelable("qrloc", new Rect(j, k, m + n, ((JSONArray)localObject).getInt(3) + i1));
          }
          if (localJSONObject.has("qrsz")) {
            localBundle.putInt("qrsz", localJSONObject.getInt("qrsz"));
          }
          if (localJSONObject.has("clip"))
          {
            localObject = new ArrayList();
            JSONArray localJSONArray1 = localJSONObject.getJSONArray("clip");
            j = 0;
            while (j < localJSONArray1.length())
            {
              JSONArray localJSONArray2 = localJSONArray1.getJSONArray(j);
              k = localJSONArray2.getInt(0);
              m = localJSONArray2.getInt(1);
              n = localJSONArray2.getInt(0);
              i1 = localJSONArray2.getInt(2);
              int i2 = localJSONArray2.getInt(1);
              ((ArrayList)localObject).add(new Rect(k, m, n + i1, localJSONArray2.getInt(3) + i2));
              j += 1;
            }
            localBundle.putParcelableArrayList("clip", (ArrayList)localObject);
          }
          localBundle.putInt("B", (int)Long.parseLong(localJSONObject.getString("B"), 16));
          if (localJSONObject.has("W")) {
            localBundle.putInt("W", (int)Long.parseLong(localJSONObject.getString("W"), 16));
          }
          for (;;)
          {
            try
            {
              localBundle.putInt("head", localJSONObject.getInt("head"));
              localBundle.putInt("v", localJSONObject.getInt("v"));
              localBundle.putInt("type", 2);
              this.jdField_a_of_type_JavaUtilList.add(localBundle);
            }
            catch (Exception localException)
            {
              if (!localJSONObject.getBoolean("head")) {
                break;
              }
            }
            localBundle.putInt("W", 16777215);
          }
          for (int j = 1;; j = 0)
          {
            localBundle.putInt("head", j);
            break;
          }
        }
        catch (JSONException localJSONException)
        {
          for (;;) {}
        }
        i += 1;
      }
    }
  }
  
  /* Error */
  private boolean a(String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: aconst_null
    //   4: astore_3
    //   5: aconst_null
    //   6: astore 4
    //   8: aload_2
    //   9: ifnull +93 -> 102
    //   12: new 82	java/io/File
    //   15: dup
    //   16: getstatic 68	com/tencent/biz/qrcode/CodeMaskManager:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   19: invokespecial 368	java/io/File:<init>	(Ljava/lang/String;)V
    //   22: invokevirtual 371	java/io/File:mkdirs	()Z
    //   25: pop
    //   26: new 82	java/io/File
    //   29: dup
    //   30: new 48	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   37: getstatic 68	com/tencent/biz/qrcode/CodeMaskManager:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   40: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: aload_1
    //   44: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: invokespecial 368	java/io/File:<init>	(Ljava/lang/String;)V
    //   53: astore_1
    //   54: aload_1
    //   55: invokevirtual 374	java/io/File:exists	()Z
    //   58: ifne +8 -> 66
    //   61: aload_1
    //   62: invokevirtual 377	java/io/File:createNewFile	()Z
    //   65: pop
    //   66: new 379	java/io/FileOutputStream
    //   69: dup
    //   70: aload_1
    //   71: invokespecial 382	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   74: astore_1
    //   75: aload_1
    //   76: aload_2
    //   77: invokevirtual 386	java/io/FileOutputStream:write	([B)V
    //   80: iconst_1
    //   81: istore 6
    //   83: iload 6
    //   85: istore 5
    //   87: aload_1
    //   88: ifnull +11 -> 99
    //   91: aload_1
    //   92: invokevirtual 389	java/io/FileOutputStream:close	()V
    //   95: iload 6
    //   97: istore 5
    //   99: iload 5
    //   101: ireturn
    //   102: iconst_0
    //   103: ifeq -4 -> 99
    //   106: new 391	java/lang/NullPointerException
    //   109: dup
    //   110: invokespecial 392	java/lang/NullPointerException:<init>	()V
    //   113: athrow
    //   114: astore_1
    //   115: iconst_0
    //   116: ireturn
    //   117: astore_1
    //   118: aload 4
    //   120: astore_1
    //   121: aload_1
    //   122: ifnull -23 -> 99
    //   125: aload_1
    //   126: invokevirtual 389	java/io/FileOutputStream:close	()V
    //   129: iconst_0
    //   130: ireturn
    //   131: astore_1
    //   132: iconst_0
    //   133: ireturn
    //   134: astore_1
    //   135: aload_3
    //   136: astore_2
    //   137: aload_2
    //   138: ifnull +7 -> 145
    //   141: aload_2
    //   142: invokevirtual 389	java/io/FileOutputStream:close	()V
    //   145: aload_1
    //   146: athrow
    //   147: astore_1
    //   148: iconst_1
    //   149: ireturn
    //   150: astore_2
    //   151: goto -6 -> 145
    //   154: astore_3
    //   155: aload_1
    //   156: astore_2
    //   157: aload_3
    //   158: astore_1
    //   159: goto -22 -> 137
    //   162: astore_2
    //   163: goto -42 -> 121
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	166	0	this	CodeMaskManager
    //   0	166	1	paramString	String
    //   0	166	2	paramArrayOfByte	byte[]
    //   4	132	3	localObject1	Object
    //   154	4	3	localObject2	Object
    //   6	113	4	localObject3	Object
    //   1	99	5	bool1	boolean
    //   81	15	6	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   106	114	114	java/io/IOException
    //   12	66	117	java/io/IOException
    //   66	75	117	java/io/IOException
    //   125	129	131	java/io/IOException
    //   12	66	134	finally
    //   66	75	134	finally
    //   91	95	147	java/io/IOException
    //   141	145	150	java/io/IOException
    //   75	80	154	finally
    //   75	80	162	java/io/IOException
  }
  
  private void b()
  {
    this.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidAppActivity.getSharedPreferences("qrcode", 0).edit();
    localEditor.putInt("lastIndex", this.jdField_a_of_type_Int);
    localEditor.commit();
  }
  
  private void b(int paramInt)
  {
    if (this.jdField_a_of_type_JavaLangThread != null) {}
    SharedPreferences localSharedPreferences;
    long l;
    do
    {
      return;
      localSharedPreferences = this.jdField_a_of_type_AndroidAppActivity.getSharedPreferences("qrcode", 0);
      l = localSharedPreferences.getLong("updateTemplate2", 0L);
    } while (System.currentTimeMillis() - l < 86400000L);
    Display localDisplay = ((WindowManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("window")).getDefaultDisplay();
    int i = localDisplay.getHeight();
    this.jdField_a_of_type_JavaLangThread = new jae(this, localSharedPreferences, localDisplay.getWidth(), i, paramInt);
    this.jdField_a_of_type_JavaLangThread.start();
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Bundle)localIterator.next();
      Bitmap localBitmap = (Bitmap)((Bundle)localObject).getParcelable("bkg");
      if (localBitmap != null) {
        localBitmap.recycle();
      }
      localObject = (Bitmap)((Bundle)localObject).getParcelable("qrbkg");
      if (localObject != null) {
        ((Bitmap)localObject).recycle();
      }
    }
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void a(CodeMaskManager.Callback paramCallback, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if ((paramBoolean1) && (paramBoolean2) && ((paramInt == 2) || (paramInt == 1)))
    {
      if (this.jdField_a_of_type_AndroidOsBundle == null)
      {
        this.jdField_a_of_type_AndroidOsBundle = new Bundle();
        this.jdField_a_of_type_AndroidOsBundle.putInt("bkgRes", 0);
        this.jdField_a_of_type_AndroidOsBundle.putInt("nameClr", -16777216);
        this.jdField_a_of_type_AndroidOsBundle.putInt("tipsClr", -8947849);
        this.jdField_a_of_type_AndroidOsBundle.putInt("B", 0);
        this.jdField_a_of_type_AndroidOsBundle.putInt("W", -9947128);
        if (paramInt != 2) {
          break label149;
        }
        this.jdField_a_of_type_AndroidOsBundle.putInt("head", 3);
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidOsBundle.putInt("type", 1);
        paramCallback.a(a(this.jdField_a_of_type_AndroidOsBundle));
        return;
        label149:
        if (paramInt == 1) {
          this.jdField_a_of_type_AndroidOsBundle.putInt("head", 4);
        }
      }
    }
    int i = a(this.jdField_a_of_type_JavaUtilList.size());
    if (i >= 0)
    {
      paramInt = i;
      if (i < this.jdField_a_of_type_JavaUtilList.size()) {}
    }
    else
    {
      paramInt = 0;
    }
    Object localObject = (Bundle)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (((Bundle)localObject).getInt("type") == 1)
    {
      paramCallback.a(a((Bundle)localObject));
      b();
      return;
    }
    localObject = new jah(this, paramCallback, (Bundle)localObject);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new jag(this, (jah)localObject, paramCallback), 10000L);
    ((jah)localObject).start();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\qrcode\CodeMaskManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */