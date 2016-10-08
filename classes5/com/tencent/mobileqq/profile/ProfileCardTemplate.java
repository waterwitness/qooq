package com.tencent.mobileqq.profile;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.NinePatchDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.util.StateSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.Utils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class ProfileCardTemplate
{
  public static long a = 0L;
  public static final String a = "qvip_profile_template.json";
  public static final HashMap a;
  public static JSONObject a;
  public static long b = 0L;
  public static final String b = "background";
  public static JSONObject b;
  public static long c = 0L;
  public static final String c = "style";
  public static long d = 0L;
  public static final String d = "583";
  public static final int e = 0;
  public static long e = 0L;
  public static final int f = 1;
  public static long f = 0L;
  public static final int g = 2;
  public static long g;
  public static long h;
  public int a;
  public boolean a;
  public int b;
  public HashMap b;
  public int c;
  private HashMap c;
  public int d;
  private HashMap d;
  public String e;
  public String f;
  public String g;
  public int h;
  public String h;
  public int i;
  public long i;
  public String i = "";
  public int j;
  public String j = "";
  public int k;
  public String k = "";
  public int l;
  public String l = "";
  public int m;
  public String m = "";
  public int n;
  public String n = "";
  public int o;
  public String o = "";
  public String p = "";
  public String q = "";
  public String r = "";
  public String s = "";
  public String t = "";
  public String u = "";
  public String v = "";
  public String w = "";
  public String x = "";
  public String y = "";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_b_of_type_Long = 1L;
    jdField_c_of_type_Long = 4L;
    jdField_d_of_type_Long = 5L;
    jdField_e_of_type_Long = 6L;
    jdField_f_of_type_Long = 7L;
    jdField_g_of_type_Long = 8L;
    jdField_h_of_type_Long = 9L;
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public ProfileCardTemplate()
  {
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_f_of_type_JavaLangString = "0";
    this.jdField_g_of_type_JavaLangString = "";
    this.jdField_h_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_c_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_d_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_c_of_type_JavaUtilHashMap.put("top", Integer.valueOf(48));
    this.jdField_c_of_type_JavaUtilHashMap.put("bottom", Integer.valueOf(80));
    this.jdField_c_of_type_JavaUtilHashMap.put("left", Integer.valueOf(80));
    this.jdField_c_of_type_JavaUtilHashMap.put("right", Integer.valueOf(80));
    this.jdField_c_of_type_JavaUtilHashMap.put("center_vertical", Integer.valueOf(80));
    this.jdField_c_of_type_JavaUtilHashMap.put("fill_vertical", Integer.valueOf(80));
    this.jdField_c_of_type_JavaUtilHashMap.put("center_horizontal", Integer.valueOf(80));
    this.jdField_c_of_type_JavaUtilHashMap.put("fill_horizontal", Integer.valueOf(80));
    this.jdField_c_of_type_JavaUtilHashMap.put("center", Integer.valueOf(80));
    this.jdField_c_of_type_JavaUtilHashMap.put("fill", Integer.valueOf(80));
    this.jdField_c_of_type_JavaUtilHashMap.put("clip_vertical", Integer.valueOf(80));
    this.jdField_c_of_type_JavaUtilHashMap.put("clip_horizontal", Integer.valueOf(80));
    this.jdField_d_of_type_JavaUtilHashMap.put("clamp", Shader.TileMode.CLAMP);
    this.jdField_d_of_type_JavaUtilHashMap.put("repeat", Shader.TileMode.REPEAT);
    this.jdField_d_of_type_JavaUtilHashMap.put("mirror", Shader.TileMode.MIRROR);
    jdField_a_of_type_JavaUtilHashMap.put(String.valueOf(jdField_b_of_type_Long), "game");
    jdField_a_of_type_JavaUtilHashMap.put(String.valueOf(jdField_c_of_type_Long), "game");
    jdField_a_of_type_JavaUtilHashMap.put(String.valueOf(jdField_d_of_type_Long), "game");
    jdField_a_of_type_JavaUtilHashMap.put(String.valueOf(jdField_e_of_type_Long), "photo");
    jdField_a_of_type_JavaUtilHashMap.put(String.valueOf(jdField_g_of_type_Long), "simple");
    jdField_a_of_type_JavaUtilHashMap.put(String.valueOf(jdField_h_of_type_Long), "shopping");
  }
  
  public static void a(View paramView, String paramString1, ProfileCardTemplate paramProfileCardTemplate, String paramString2)
  {
    if ((paramView != null) && (paramProfileCardTemplate != null) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      paramProfileCardTemplate = paramProfileCardTemplate.jdField_b_of_type_JavaUtilHashMap.get(paramString2);
      if (paramProfileCardTemplate != null)
      {
        if ((!paramString1.equalsIgnoreCase("color")) || (!(paramView instanceof TextView))) {
          break label102;
        }
        paramView = (TextView)paramView;
        if (!(paramProfileCardTemplate instanceof ColorStateList)) {
          break label72;
        }
        paramView.setTextColor((ColorStateList)paramProfileCardTemplate);
      }
    }
    label71:
    label72:
    label102:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          break label71;
                          break label71;
                          break label71;
                          break label71;
                          break label71;
                          break label71;
                          break label71;
                          break label71;
                          break label71;
                          do
                          {
                            return;
                          } while (!(paramProfileCardTemplate instanceof String));
                          paramString1 = (String)paramProfileCardTemplate;
                        } while (!paramString1.startsWith("#"));
                        paramView.setTextColor(Color.parseColor(paramString1));
                        return;
                        if (!paramString1.equalsIgnoreCase("background")) {
                          break;
                        }
                        if ((paramProfileCardTemplate instanceof Drawable))
                        {
                          paramString1 = ((Drawable)paramProfileCardTemplate).getConstantState().newDrawable();
                          paramProfileCardTemplate = new Rect();
                          paramString1.getPadding(paramProfileCardTemplate);
                          int i1 = paramView.getPaddingTop();
                          int i2 = paramProfileCardTemplate.top;
                          int i3 = paramView.getPaddingLeft();
                          int i4 = paramProfileCardTemplate.left;
                          int i5 = paramView.getPaddingRight();
                          int i6 = paramProfileCardTemplate.right;
                          int i7 = paramView.getPaddingBottom();
                          int i8 = paramProfileCardTemplate.bottom;
                          if (Build.VERSION.SDK_INT >= 16) {
                            paramView.setBackground(paramString1);
                          }
                          for (;;)
                          {
                            paramView.setPadding(i3 + i4, i1 + i2, i5 + i6, i8 + i7);
                            return;
                            paramView.setBackgroundDrawable(paramString1);
                          }
                        }
                      } while (!(paramProfileCardTemplate instanceof String));
                      paramString1 = (String)paramProfileCardTemplate;
                    } while (!paramString1.startsWith("#"));
                    paramView.setBackgroundColor(Color.parseColor(paramString1));
                    return;
                    if ((!paramString1.equalsIgnoreCase("drawableleft")) || (!(paramView instanceof TextView))) {
                      break;
                    }
                  } while (!(paramProfileCardTemplate instanceof Drawable));
                  paramView = (TextView)paramView;
                } while (!(paramProfileCardTemplate instanceof Drawable));
                paramView.setCompoundDrawablesWithIntrinsicBounds(((Drawable)paramProfileCardTemplate).getConstantState().newDrawable(), null, null, null);
                return;
                if ((!paramString1.equalsIgnoreCase("drawableright")) || (!(paramView instanceof TextView))) {
                  break;
                }
              } while (!(paramProfileCardTemplate instanceof Drawable));
              paramView = (TextView)paramView;
            } while (!(paramProfileCardTemplate instanceof Drawable));
            paramView.setCompoundDrawablesWithIntrinsicBounds(null, null, ((Drawable)paramProfileCardTemplate).getConstantState().newDrawable(), null);
            return;
            if ((!paramString1.equalsIgnoreCase("src")) || (!(paramView instanceof ImageView))) {
              break;
            }
          } while (!(paramProfileCardTemplate instanceof Drawable));
          paramView = (ImageView)paramView;
        } while (!(paramProfileCardTemplate instanceof Drawable));
        paramView.setImageDrawable(((Drawable)paramProfileCardTemplate).getConstantState().newDrawable());
        return;
      } while ((!paramString1.equalsIgnoreCase("contentBackground")) || (!(paramView instanceof ListView)) || (!(paramProfileCardTemplate instanceof Drawable)));
      paramView = (ListView)paramView;
    } while (!(paramProfileCardTemplate instanceof Drawable));
    paramView.setContentBackground(((Drawable)paramProfileCardTemplate).getConstantState().newDrawable());
  }
  
  public ColorStateList a(JSONArray paramJSONArray)
  {
    int i4;
    int i3;
    Object localObject1;
    Object localObject2;
    int i5;
    Object localObject3;
    int i1;
    int i2;
    int i6;
    if (paramJSONArray != null)
    {
      i4 = 20;
      i3 = 0;
      localObject1 = new int[20];
      localObject2 = new int[20][];
      int i7 = paramJSONArray.length();
      i5 = 0;
      if (i5 < i7)
      {
        localObject3 = paramJSONArray.optJSONObject(i5);
        if ((localObject3 == null) || (!((JSONObject)localObject3).has("color"))) {
          break label746;
        }
        Object localObject4 = ((JSONObject)localObject3).optString("color");
        if ((localObject4 == null) || (((String)localObject4).length() <= 0)) {
          break label746;
        }
        Object localObject5 = ((JSONObject)localObject3).keys();
        int[] arrayOfInt = new int[((JSONObject)localObject3).length()];
        i1 = -65536;
        i2 = 0;
        if (((Iterator)localObject5).hasNext())
        {
          String str = (String)((Iterator)localObject5).next();
          if (str.equalsIgnoreCase("state_pressed")) {
            if (((JSONObject)localObject3).optBoolean("state_pressed"))
            {
              i6 = 16842919;
              label156:
              arrayOfInt[i2] = i6;
              i6 = i2 + 1;
              i2 = i1;
              i1 = i6;
            }
          }
          for (;;)
          {
            label177:
            i6 = i2;
            i2 = i1;
            i1 = i6;
            break;
            i6 = -16842919;
            break label156;
            if (str.equalsIgnoreCase("state_focused"))
            {
              if (((JSONObject)localObject3).optBoolean("state_focused")) {}
              for (i6 = 16842908;; i6 = -16842908)
              {
                arrayOfInt[i2] = i6;
                i6 = i2 + 1;
                i2 = i1;
                i1 = i6;
                break;
              }
            }
            if (str.equalsIgnoreCase("state_selected"))
            {
              if (((JSONObject)localObject3).optBoolean("state_selected")) {}
              for (i6 = 16842913;; i6 = -16842913)
              {
                arrayOfInt[i2] = i6;
                i6 = i2 + 1;
                i2 = i1;
                i1 = i6;
                break;
              }
            }
            if (str.equalsIgnoreCase("state_checkable"))
            {
              if (((JSONObject)localObject3).optBoolean("state_checkable")) {}
              for (i6 = 16842911;; i6 = -16842911)
              {
                arrayOfInt[i2] = i6;
                i6 = i2 + 1;
                i2 = i1;
                i1 = i6;
                break;
              }
            }
            if (str.equalsIgnoreCase("state_checked"))
            {
              if (((JSONObject)localObject3).optBoolean("state_checked")) {}
              for (i6 = 16842912;; i6 = -16842912)
              {
                arrayOfInt[i2] = i6;
                i6 = i2 + 1;
                i2 = i1;
                i1 = i6;
                break;
              }
            }
            if (str.equalsIgnoreCase("state_enabled"))
            {
              if (((JSONObject)localObject3).optBoolean("state_enabled")) {}
              for (i6 = 16842910;; i6 = -16842910)
              {
                arrayOfInt[i2] = i6;
                i6 = i2 + 1;
                i2 = i1;
                i1 = i6;
                break;
              }
            }
            if (str.equalsIgnoreCase("state_window_focused"))
            {
              if (((JSONObject)localObject3).optBoolean("state_window_focused")) {}
              for (i6 = 16842909;; i6 = -16842909)
              {
                arrayOfInt[i2] = i6;
                i6 = i2 + 1;
                i2 = i1;
                i1 = i6;
                break;
              }
            }
            if (!str.equalsIgnoreCase("color")) {
              break label731;
            }
            i6 = Color.parseColor((String)localObject4);
            i1 = i2;
            i2 = i6;
          }
        }
        localObject5 = StateSet.trimStateSet(arrayOfInt, i2);
        if (i3 + 1 < i4) {
          break label724;
        }
        i2 = i3 + 1;
        localObject3 = new int[i2];
        System.arraycopy(localObject1, 0, localObject3, 0, i3);
        localObject4 = new int[i2][];
        System.arraycopy(localObject2, 0, localObject4, 0, i3);
        localObject1 = localObject3;
        localObject2 = localObject4;
        label645:
        localObject1[i3] = i1;
        localObject2[i3] = localObject5;
        i1 = i3 + 1;
        i4 = i2;
      }
    }
    for (;;)
    {
      i5 += 1;
      i3 = i1;
      break;
      paramJSONArray = new int[i3];
      localObject3 = new int[i3][];
      System.arraycopy(localObject1, 0, paramJSONArray, 0, i3);
      System.arraycopy(localObject2, 0, localObject3, 0, i3);
      return new ColorStateList((int[][])localObject3, paramJSONArray);
      return null;
      label724:
      i2 = i4;
      break label645;
      label731:
      i6 = i1;
      i1 = i2;
      i2 = i6;
      break label177;
      label746:
      i1 = i3;
    }
  }
  
  public Drawable a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "getTemplateDrawable fileName=" + paramString);
    }
    String str = null;
    Object localObject2 = null;
    label698:
    label704:
    label709:
    label712:
    for (;;)
    {
      try
      {
        localResources = paramQQAppInterface.a().getResources();
        localObject1 = str;
        if (paramString == null) {
          break label709;
        }
        localObject1 = str;
        if (paramString.length() <= 0) {
          break label709;
        }
        Object localObject3 = ProfileCardUtil.a(paramQQAppInterface, -1L);
        localObject1 = str;
        if (localObject3 == null) {
          break label709;
        }
        localObject1 = str;
        if (((String)localObject3).length() <= 0) {
          break label709;
        }
        localObject1 = (String)localObject3 + File.separator + paramString;
        str = "profilecard:" + (String)localObject1;
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "getTemplateDrawable filePath=" + (String)localObject1);
        }
        if (paramBoolean)
        {
          localObject3 = (Pair)BaseApplicationImpl.a.get(str);
          if ((localObject3 != null) && (((Pair)localObject3).first != null))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.profilecard.FrdProfileCard", 2, "getTemplateDrawable form sImageCache filePath=" + (String)localObject1);
            }
            return ((Drawable.ConstantState)((Pair)localObject3).first).newDrawable();
          }
        }
        localObject3 = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject3).inDensity = 320;
        ((BitmapFactory.Options)localObject3).inScreenDensity = paramQQAppInterface.a().getResources().getDisplayMetrics().densityDpi;
        ((BitmapFactory.Options)localObject3).inTargetDensity = paramQQAppInterface.a().getResources().getDisplayMetrics().densityDpi;
        ((BitmapFactory.Options)localObject3).inScaled = true;
        if ((paramString.endsWith(".jpg")) || (paramString.endsWith(".jpeg"))) {
          ((BitmapFactory.Options)localObject3).inPreferredConfig = Bitmap.Config.RGB_565;
        }
        paramQQAppInterface = BitmapFactory.decodeStream(new BufferedInputStream(new FileInputStream((String)localObject1)), null, (BitmapFactory.Options)localObject3);
        if (paramQQAppInterface == null) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "getTemplateDrawable bitmap density=" + paramQQAppInterface.getDensity() + ",width=" + paramQQAppInterface.getWidth() + ",height=" + paramQQAppInterface.getHeight());
        }
        i1 = Utils.getBitmapSize(paramQQAppInterface);
        if (!paramString.endsWith(".9.png")) {
          continue;
        }
        localObject1 = paramQQAppInterface.getNinePatchChunk();
        if (localObject1 == null) {
          break label704;
        }
        paramQQAppInterface = new NinePatchDrawable(localResources, paramQQAppInterface, (byte[])localObject1, new Rect(0, 0, 0, 0), null);
        paramQQAppInterface.setTargetDensity(localResources.getDisplayMetrics());
      }
      catch (OutOfMemoryError paramQQAppInterface)
      {
        Resources localResources;
        paramQQAppInterface.printStackTrace();
        return null;
        if ((!paramString.endsWith(".png")) && (!paramString.endsWith(".jpg")) && (!paramString.endsWith(".jpeg"))) {
          continue;
        }
        paramQQAppInterface = new BitmapDrawable(localResources, paramQQAppInterface);
        paramQQAppInterface.setTargetDensity(localResources.getDisplayMetrics());
        continue;
        if (!QLog.isColorLevel()) {
          break label698;
        }
        QLog.d("Q.profilecard.FrdProfileCard", 2, "getTemplateDrawable file not ");
        paramQQAppInterface = (QQAppInterface)localObject2;
        continue;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.profilecard.FrdProfileCard", 2, "getTemplateDrawable bitmap is null");
        int i1 = 0;
        paramQQAppInterface = (QQAppInterface)localObject2;
        continue;
      }
      catch (Throwable paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.profilecard.FrdProfileCard", 2, "getTemplateDrawable exception fileName=" + paramString + ",msg=" + paramQQAppInterface.getMessage());
        return null;
      }
      Object localObject1 = paramQQAppInterface;
      if (paramQQAppInterface != null)
      {
        localObject1 = paramQQAppInterface;
        if (paramBoolean)
        {
          BaseApplicationImpl.a.put(str, new Pair(paramQQAppInterface.getConstantState(), Integer.valueOf(i1)));
          return paramQQAppInterface;
          paramQQAppInterface = (QQAppInterface)localObject2;
          continue;
          paramQQAppInterface = null;
          break label712;
        }
      }
      return (Drawable)localObject1;
    }
  }
  
  public Drawable a(QQAppInterface paramQQAppInterface, JSONObject paramJSONObject)
  {
    if ((paramJSONObject != null) && (paramJSONObject.has("src")))
    {
      Object localObject = paramJSONObject.optString("src");
      if ((localObject != null) && (((String)localObject).length() > 0))
      {
        localObject = (BitmapDrawable)a(paramQQAppInterface, (String)localObject, true);
        Iterator localIterator = paramJSONObject.keys();
        if (localObject != null) {
          for (;;)
          {
            paramQQAppInterface = (QQAppInterface)localObject;
            if (!localIterator.hasNext()) {
              break;
            }
            paramQQAppInterface = (String)localIterator.next();
            if (paramQQAppInterface.equalsIgnoreCase("antialias"))
            {
              ((BitmapDrawable)localObject).setAntiAlias(paramJSONObject.optBoolean("antialias"));
            }
            else if (paramQQAppInterface.equalsIgnoreCase("dither"))
            {
              ((BitmapDrawable)localObject).setDither(paramJSONObject.optBoolean("dither"));
            }
            else if (paramQQAppInterface.equalsIgnoreCase("filter"))
            {
              ((BitmapDrawable)localObject).setFilterBitmap(paramJSONObject.optBoolean("filter"));
            }
            else if (paramQQAppInterface.equalsIgnoreCase("gravity"))
            {
              paramQQAppInterface = paramJSONObject.optString("gravity").toLowerCase();
              if ((!TextUtils.isEmpty(paramQQAppInterface)) && (this.jdField_c_of_type_JavaUtilHashMap.containsKey(paramQQAppInterface))) {
                ((BitmapDrawable)localObject).setGravity(((Integer)this.jdField_c_of_type_JavaUtilHashMap.get(paramQQAppInterface)).intValue());
              }
            }
            else if (paramQQAppInterface.equalsIgnoreCase("tileMode"))
            {
              paramQQAppInterface = paramJSONObject.optString("tileMode", "disabled").toLowerCase();
              if ((!TextUtils.isEmpty(paramQQAppInterface)) && (this.jdField_d_of_type_JavaUtilHashMap.containsKey(paramQQAppInterface)))
              {
                paramQQAppInterface = (Shader.TileMode)this.jdField_d_of_type_JavaUtilHashMap.get(paramQQAppInterface);
                ((BitmapDrawable)localObject).setTileModeXY(paramQQAppInterface, paramQQAppInterface);
              }
              else
              {
                ((BitmapDrawable)localObject).setTileModeXY(null, null);
              }
            }
          }
        }
      }
    }
    paramQQAppInterface = null;
    return paramQQAppInterface;
  }
  
  public StateListDrawable a(QQAppInterface paramQQAppInterface, JSONArray paramJSONArray)
  {
    StateListDrawable localStateListDrawable;
    int i2;
    Object localObject;
    String str1;
    int[] arrayOfInt;
    int i1;
    Drawable localDrawable;
    label97:
    String str2;
    int i3;
    if (paramJSONArray != null)
    {
      localStateListDrawable = new StateListDrawable();
      int i4 = paramJSONArray.length();
      i2 = 0;
      if (i2 < i4)
      {
        localObject = paramJSONArray.optJSONObject(i2);
        if ((localObject != null) && (((JSONObject)localObject).has("drawable")))
        {
          str1 = ((JSONObject)localObject).optString("drawable");
          if ((str1 != null) && (str1.length() > 0))
          {
            Iterator localIterator = ((JSONObject)localObject).keys();
            arrayOfInt = new int[((JSONObject)localObject).length()];
            i1 = 0;
            localDrawable = null;
            if (localIterator.hasNext())
            {
              str2 = (String)localIterator.next();
              i3 = Build.VERSION.SDK_INT;
              if (str2.equalsIgnoreCase("state_pressed")) {
                if (((JSONObject)localObject).optBoolean("state_pressed"))
                {
                  i3 = 16842919;
                  label151:
                  arrayOfInt[i1] = i3;
                  i1 += 1;
                }
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      break label97;
      i3 = -16842919;
      break label151;
      if (str2.equalsIgnoreCase("state_focused"))
      {
        if (((JSONObject)localObject).optBoolean("state_focused")) {}
        for (i3 = 16842908;; i3 = -16842908)
        {
          arrayOfInt[i1] = i3;
          i1 += 1;
          break;
        }
      }
      if ((str2.equalsIgnoreCase("state_hovered")) && (i3 >= 14))
      {
        if (((JSONObject)localObject).optBoolean("state_hovered")) {}
        for (i3 = 16843623;; i3 = -16843623)
        {
          arrayOfInt[i1] = i3;
          i1 += 1;
          break;
        }
      }
      if (str2.equalsIgnoreCase("state_selected"))
      {
        if (((JSONObject)localObject).optBoolean("state_selected")) {}
        for (i3 = 16842913;; i3 = -16842913)
        {
          arrayOfInt[i1] = i3;
          i1 += 1;
          break;
        }
      }
      if (str2.equalsIgnoreCase("state_checkable"))
      {
        if (((JSONObject)localObject).optBoolean("state_checkable")) {}
        for (i3 = 16842911;; i3 = -16842911)
        {
          arrayOfInt[i1] = i3;
          i1 += 1;
          break;
        }
      }
      if (str2.equalsIgnoreCase("state_checked"))
      {
        if (((JSONObject)localObject).optBoolean("state_checked")) {}
        for (i3 = 16842912;; i3 = -16842912)
        {
          arrayOfInt[i1] = i3;
          i1 += 1;
          break;
        }
      }
      if (str2.equalsIgnoreCase("state_enabled"))
      {
        if (((JSONObject)localObject).optBoolean("state_enabled")) {}
        for (i3 = 16842910;; i3 = -16842910)
        {
          arrayOfInt[i1] = i3;
          i1 += 1;
          break;
        }
      }
      if ((str2.equalsIgnoreCase("state_activated")) && (i3 >= 11))
      {
        if (((JSONObject)localObject).optBoolean("state_activated")) {}
        for (i3 = 16843518;; i3 = -16843518)
        {
          arrayOfInt[i1] = i3;
          i1 += 1;
          break;
        }
      }
      if (str2.equalsIgnoreCase("state_window_focused"))
      {
        if (((JSONObject)localObject).optBoolean("state_window_focused")) {}
        for (i3 = 16842909;; i3 = -16842909)
        {
          arrayOfInt[i1] = i3;
          i1 += 1;
          break;
        }
      }
      if (str2.equalsIgnoreCase("drawable"))
      {
        localDrawable = a(paramQQAppInterface, str1, true);
        continue;
        localObject = StateSet.trimStateSet(arrayOfInt, i1);
        if (localDrawable != null) {
          localStateListDrawable.addState((int[])localObject, localDrawable);
        }
        i2 += 1;
        break;
        return localStateListDrawable;
        return null;
      }
    }
  }
  
  /* Error */
  public JSONObject a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    // Byte code:
    //   0: lload_2
    //   1: lconst_1
    //   2: lcmp
    //   3: ifne +60 -> 63
    //   6: ldc_w 682
    //   9: astore 4
    //   11: invokestatic 423	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   14: ifeq +31 -> 45
    //   17: ldc_w 425
    //   20: iconst_2
    //   21: new 427	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 428	java/lang/StringBuilder:<init>	()V
    //   28: ldc_w 684
    //   31: invokevirtual 434	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: aload 4
    //   36: invokevirtual 434	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: invokevirtual 438	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokestatic 441	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   45: lload_2
    //   46: lconst_1
    //   47: lcmp
    //   48: ifne +23 -> 71
    //   51: getstatic 686	com/tencent/mobileqq/profile/ProfileCardTemplate:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   54: ifnull +17 -> 71
    //   57: getstatic 686	com/tencent/mobileqq/profile/ProfileCardTemplate:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   60: astore_1
    //   61: aload_1
    //   62: areturn
    //   63: ldc_w 688
    //   66: astore 4
    //   68: goto -57 -> 11
    //   71: lload_2
    //   72: lconst_1
    //   73: lcmp
    //   74: ifeq +13 -> 87
    //   77: getstatic 690	com/tencent/mobileqq/profile/ProfileCardTemplate:jdField_b_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   80: ifnull +7 -> 87
    //   83: getstatic 690	com/tencent/mobileqq/profile/ProfileCardTemplate:jdField_b_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   86: areturn
    //   87: invokestatic 423	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   90: ifeq +31 -> 121
    //   93: ldc_w 425
    //   96: iconst_2
    //   97: new 427	java/lang/StringBuilder
    //   100: dup
    //   101: invokespecial 428	java/lang/StringBuilder:<init>	()V
    //   104: ldc_w 692
    //   107: invokevirtual 434	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: aload 4
    //   112: invokevirtual 434	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: invokevirtual 438	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: invokestatic 441	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   121: aload_1
    //   122: ldc2_w 453
    //   125: invokestatic 459	com/tencent/mobileqq/util/ProfileCardUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;J)Ljava/lang/String;
    //   128: astore_1
    //   129: aload_1
    //   130: ifnull +142 -> 272
    //   133: aload_1
    //   134: invokevirtual 351	java/lang/String:length	()I
    //   137: ifle +135 -> 272
    //   140: new 427	java/lang/StringBuilder
    //   143: dup
    //   144: invokespecial 428	java/lang/StringBuilder:<init>	()V
    //   147: aload_1
    //   148: invokevirtual 434	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: getstatic 464	java/io/File:separator	Ljava/lang/String;
    //   154: invokevirtual 434	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: aload 4
    //   159: invokevirtual 434	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: invokevirtual 438	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   165: astore_1
    //   166: new 461	java/io/File
    //   169: dup
    //   170: aload_1
    //   171: invokespecial 693	java/io/File:<init>	(Ljava/lang/String;)V
    //   174: astore_1
    //   175: aload_1
    //   176: invokevirtual 696	java/io/File:exists	()Z
    //   179: ifeq +239 -> 418
    //   182: new 530	java/io/FileInputStream
    //   185: dup
    //   186: aload_1
    //   187: invokespecial 699	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   190: astore 4
    //   192: aload 4
    //   194: astore_1
    //   195: new 701	java/io/ByteArrayOutputStream
    //   198: dup
    //   199: invokespecial 702	java/io/ByteArrayOutputStream:<init>	()V
    //   202: astore 5
    //   204: aload 4
    //   206: astore_1
    //   207: sipush 4096
    //   210: newarray <illegal type>
    //   212: astore 6
    //   214: aload 4
    //   216: astore_1
    //   217: aload 4
    //   219: aload 6
    //   221: iconst_0
    //   222: sipush 4096
    //   225: invokevirtual 708	java/io/InputStream:read	([BII)I
    //   228: istore 7
    //   230: iload 7
    //   232: iconst_m1
    //   233: if_icmpeq +41 -> 274
    //   236: aload 4
    //   238: astore_1
    //   239: aload 5
    //   241: aload 6
    //   243: iconst_0
    //   244: iload 7
    //   246: invokevirtual 712	java/io/ByteArrayOutputStream:write	([BII)V
    //   249: goto -35 -> 214
    //   252: astore 5
    //   254: aload 4
    //   256: astore_1
    //   257: aload 5
    //   259: invokevirtual 713	java/lang/Exception:printStackTrace	()V
    //   262: aload 4
    //   264: ifnull +8 -> 272
    //   267: aload 4
    //   269: invokevirtual 716	java/io/InputStream:close	()V
    //   272: aconst_null
    //   273: areturn
    //   274: aload 4
    //   276: astore_1
    //   277: new 196	java/lang/String
    //   280: dup
    //   281: aload 5
    //   283: invokevirtual 719	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   286: ldc_w 721
    //   289: invokespecial 724	java/lang/String:<init>	([BLjava/lang/String;)V
    //   292: astore 6
    //   294: aload 4
    //   296: astore 5
    //   298: aload 6
    //   300: ifnull +121 -> 421
    //   303: aload 4
    //   305: astore 5
    //   307: aload 4
    //   309: astore_1
    //   310: aload 6
    //   312: invokevirtual 351	java/lang/String:length	()I
    //   315: ifle +106 -> 421
    //   318: lload_2
    //   319: lconst_1
    //   320: lcmp
    //   321: ifne +50 -> 371
    //   324: aload 4
    //   326: astore_1
    //   327: new 343	org/json/JSONObject
    //   330: dup
    //   331: aload 6
    //   333: invokespecial 725	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   336: putstatic 686	com/tencent/mobileqq/profile/ProfileCardTemplate:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   339: aload 4
    //   341: astore_1
    //   342: getstatic 686	com/tencent/mobileqq/profile/ProfileCardTemplate:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   345: astore 5
    //   347: aload 5
    //   349: astore_1
    //   350: aload 4
    //   352: ifnull -291 -> 61
    //   355: aload 4
    //   357: invokevirtual 716	java/io/InputStream:close	()V
    //   360: aload 5
    //   362: areturn
    //   363: astore_1
    //   364: aload_1
    //   365: invokevirtual 726	java/io/IOException:printStackTrace	()V
    //   368: aload 5
    //   370: areturn
    //   371: aload 4
    //   373: astore_1
    //   374: new 343	org/json/JSONObject
    //   377: dup
    //   378: aload 6
    //   380: invokespecial 725	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   383: putstatic 690	com/tencent/mobileqq/profile/ProfileCardTemplate:jdField_b_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   386: aload 4
    //   388: astore_1
    //   389: getstatic 690	com/tencent/mobileqq/profile/ProfileCardTemplate:jdField_b_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   392: astore 5
    //   394: aload 5
    //   396: astore_1
    //   397: aload 4
    //   399: ifnull -338 -> 61
    //   402: aload 4
    //   404: invokevirtual 716	java/io/InputStream:close	()V
    //   407: aload 5
    //   409: areturn
    //   410: astore_1
    //   411: aload_1
    //   412: invokevirtual 726	java/io/IOException:printStackTrace	()V
    //   415: aload 5
    //   417: areturn
    //   418: aconst_null
    //   419: astore 5
    //   421: aload 5
    //   423: ifnull -151 -> 272
    //   426: aload 5
    //   428: invokevirtual 716	java/io/InputStream:close	()V
    //   431: goto -159 -> 272
    //   434: astore_1
    //   435: aload_1
    //   436: invokevirtual 726	java/io/IOException:printStackTrace	()V
    //   439: goto -167 -> 272
    //   442: astore_1
    //   443: aload_1
    //   444: invokevirtual 726	java/io/IOException:printStackTrace	()V
    //   447: goto -175 -> 272
    //   450: astore 4
    //   452: aconst_null
    //   453: astore_1
    //   454: aload_1
    //   455: ifnull +7 -> 462
    //   458: aload_1
    //   459: invokevirtual 716	java/io/InputStream:close	()V
    //   462: aload 4
    //   464: athrow
    //   465: astore_1
    //   466: aload_1
    //   467: invokevirtual 726	java/io/IOException:printStackTrace	()V
    //   470: goto -8 -> 462
    //   473: astore 4
    //   475: goto -21 -> 454
    //   478: astore 5
    //   480: aconst_null
    //   481: astore 4
    //   483: goto -229 -> 254
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	486	0	this	ProfileCardTemplate
    //   0	486	1	paramQQAppInterface	QQAppInterface
    //   0	486	2	paramLong	long
    //   9	394	4	localObject1	Object
    //   450	13	4	localObject2	Object
    //   473	1	4	localObject3	Object
    //   481	1	4	localObject4	Object
    //   202	38	5	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   252	30	5	localException1	Exception
    //   296	131	5	localObject5	Object
    //   478	1	5	localException2	Exception
    //   212	167	6	localObject6	Object
    //   228	17	7	i1	int
    // Exception table:
    //   from	to	target	type
    //   195	204	252	java/lang/Exception
    //   207	214	252	java/lang/Exception
    //   217	230	252	java/lang/Exception
    //   239	249	252	java/lang/Exception
    //   277	294	252	java/lang/Exception
    //   310	318	252	java/lang/Exception
    //   327	339	252	java/lang/Exception
    //   342	347	252	java/lang/Exception
    //   374	386	252	java/lang/Exception
    //   389	394	252	java/lang/Exception
    //   355	360	363	java/io/IOException
    //   402	407	410	java/io/IOException
    //   426	431	434	java/io/IOException
    //   267	272	442	java/io/IOException
    //   166	192	450	finally
    //   458	462	465	java/io/IOException
    //   195	204	473	finally
    //   207	214	473	finally
    //   217	230	473	finally
    //   239	249	473	finally
    //   257	262	473	finally
    //   277	294	473	finally
    //   310	318	473	finally
    //   327	339	473	finally
    //   342	347	473	finally
    //   374	386	473	finally
    //   389	394	473	finally
    //   166	192	478	java/lang/Exception
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2)
  {
    boolean bool2 = false;
    String str2;
    label84:
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "initTemplateConfig config file is " + paramLong1);
      }
      localObject1 = "";
      str2 = (String)jdField_a_of_type_JavaUtilHashMap.get(String.valueOf(paramLong2));
      localObject2 = localObject1;
      try
      {
        localJSONObject1 = a(paramQQAppInterface, paramLong1);
        if (localJSONObject1 != null) {
          break label84;
        }
        bool1 = bool2;
      }
      catch (Exception paramQQAppInterface)
      {
        try
        {
          do
          {
            JSONObject localJSONObject1;
            Iterator localIterator;
            if (!localIterator.hasNext()) {
              break label782;
            }
            str1 = (String)localIterator.next();
            localObject2 = str1;
            if (!str1.startsWith("common"))
            {
              localObject2 = str1;
              if (TextUtils.isEmpty(str2)) {
                break label733;
              }
              localObject2 = str1;
              if (!str1.startsWith(str2)) {
                break label733;
              }
            }
            localObject2 = str1;
            localJSONObject2 = localJSONObject1.optJSONObject(str1);
            if (localJSONObject2 == null) {
              break;
            }
            localObject2 = str1;
            str3 = localJSONObject2.optString("type");
            if (str3 == null) {
              break label809;
            }
            localObject2 = str1;
            if (str3.length() <= 0) {
              break label809;
            }
            localObject1 = null;
            localObject2 = str1;
            if (str3.equalsIgnoreCase("ColorStateList"))
            {
              localObject2 = str1;
              localObject1 = a(localJSONObject2.optJSONArray("data"));
            }
            while (localObject1 != null)
            {
              localObject2 = str1;
              this.jdField_b_of_type_JavaUtilHashMap.put(str1, localObject1);
              localObject2 = str1;
              if (!QLog.isColorLevel()) {
                break label809;
              }
              localObject2 = str1;
              QLog.d("Q.profilecard.FrdProfileCard", 2, "initTemplateConfig config key= " + str1 + ",put templateAttr and size=" + this.jdField_b_of_type_JavaUtilHashMap.size());
              break label809;
              localObject2 = str1;
              if (str3.equalsIgnoreCase("BitmapDrawable"))
              {
                localObject2 = str1;
                localObject1 = a(paramQQAppInterface, localJSONObject2.optString("data"), true);
              }
              else
              {
                localObject2 = str1;
                if (str3.equalsIgnoreCase("XMLBitmap"))
                {
                  localObject2 = str1;
                  localObject1 = a(paramQQAppInterface, localJSONObject2.optJSONObject("data"));
                }
                else
                {
                  localObject2 = str1;
                  if (str3.equalsIgnoreCase("StateListDrawable"))
                  {
                    localObject2 = str1;
                    localObject1 = a(paramQQAppInterface, localJSONObject2.optJSONArray("data"));
                  }
                  else
                  {
                    localObject2 = str1;
                    if (str3.equalsIgnoreCase("String"))
                    {
                      localObject2 = str1;
                      localObject1 = localJSONObject2.optString("data");
                    }
                    else
                    {
                      localObject2 = str1;
                      if (str3.equalsIgnoreCase("Color"))
                      {
                        localObject2 = str1;
                        localObject1 = localJSONObject2.optString("data");
                      }
                    }
                  }
                }
              }
            }
            bool1 = bool2;
            localObject2 = str1;
          } while (!QLog.isColorLevel());
          localObject2 = str1;
          QLog.d("Q.profilecard.FrdProfileCard", 2, "initTemplateConfig config key= " + str1 + ",init error");
          bool1 = bool2;
        }
        catch (Exception paramQQAppInterface)
        {
          for (;;)
          {
            boolean bool1;
            localObject2 = localObject1;
          }
          localObject1 = str1;
        }
        paramQQAppInterface = paramQQAppInterface;
        if (!QLog.isColorLevel()) {
          break label645;
        }
        localObject1 = paramQQAppInterface.getClass().getName() + "," + paramQQAppInterface.getMessage();
        QLog.d("Q.profilecard.FrdProfileCard", 2, "initTemplateConfig key=" + (String)localObject2 + ",exception msg=" + (String)localObject1);
        paramQQAppInterface.printStackTrace();
        i1 = 0;
        if (i1 == 0) {
          break label788;
        }
      }
      return bool1;
    }
    finally {}
    Object localObject2 = localObject1;
    localIterator = localJSONObject1.keys();
    Object localObject1 = "";
    for (;;)
    {
      label99:
      String str1;
      JSONObject localJSONObject2;
      String str3;
      label645:
      label652:
      int i1 = this.jdField_b_of_type_JavaUtilHashMap.size();
      if (i1 > 0) {}
      label733:
      label782:
      label788:
      for (bool1 = true;; bool1 = false)
      {
        break;
        localObject2 = str1;
        if (!QLog.isColorLevel()) {
          break label809;
        }
        localObject2 = str1;
        QLog.d("Q.profilecard.FrdProfileCard", 2, "initTemplateConfig config key= " + str1 + ",value is null");
        break label809;
        localObject2 = str1;
        if (!QLog.isColorLevel()) {
          break label802;
        }
        localObject2 = str1;
        QLog.d("Q.profilecard.FrdProfileCard", 2, "initTemplateConfig config key is not used,key=" + str1);
        localObject1 = str1;
        break label99;
        i1 = 1;
        break label652;
      }
      label802:
      continue;
      label809:
      localObject1 = str1;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Field[] arrayOfField = getClass().getFields();
    localStringBuilder.append("ProfileCardTemplate:");
    int i2 = arrayOfField.length;
    int i1 = 0;
    for (;;)
    {
      if (i1 < i2)
      {
        Field localField = arrayOfField[i1];
        if (localField.getModifiers() != 8) {}
        try
        {
          Object localObject = localField.get(this);
          localStringBuilder.append(localField.getName());
          localStringBuilder.append('=');
          localStringBuilder.append(localObject);
          localStringBuilder.append(',');
          i1 += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
        }
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\profile\ProfileCardTemplate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */