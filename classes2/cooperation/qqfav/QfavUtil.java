package cooperation.qqfav;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.StructMsgUtils;
import com.tencent.mobileqq.structmsg.view.StructMsgItemImage;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayoutDefault;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public final class QfavUtil
{
  private static final int jdField_a_of_type_Int = 209715200;
  private static final Map jdField_a_of_type_JavaUtilMap;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    a = new HashMap();
  }
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 1;
    case 1: 
      return 2;
    case 3000: 
      return 3;
    }
    return 5;
  }
  
  static ContentValues a(Entity paramEntity, String paramString)
  {
    ContentValues localContentValues = new ContentValues();
    Iterator localIterator = a(paramEntity).iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (Field)localIterator.next();
      String str = paramString + ((Field)localObject1).getName();
      if (!((Field)localObject1).isAccessible()) {
        ((Field)localObject1).setAccessible(true);
      }
      Object localObject3;
      try
      {
        localObject1 = ((Field)localObject1).get(paramEntity);
        if ((localObject1 instanceof Entity)) {
          localContentValues.putAll(a((Entity)localObject1, str + "."));
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        for (;;)
        {
          localIllegalArgumentException.printStackTrace();
          Object localObject2 = null;
        }
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        for (;;)
        {
          localIllegalAccessException.printStackTrace();
          localObject3 = null;
        }
        if ((localObject3 instanceof Integer))
        {
          localContentValues.put(str, (Integer)localObject3);
          continue;
        }
        if ((localObject3 instanceof Long))
        {
          localContentValues.put(str, (Long)localObject3);
          continue;
        }
        if ((localObject3 instanceof String))
        {
          localContentValues.put(str, (String)localObject3);
          continue;
        }
        if ((localObject3 instanceof byte[]))
        {
          localContentValues.put(str, (byte[])localObject3);
          continue;
        }
        if ((localObject3 instanceof Short))
        {
          localContentValues.put(str, (Short)localObject3);
          continue;
        }
        if ((localObject3 instanceof Boolean))
        {
          localContentValues.put(str, (Boolean)localObject3);
          continue;
        }
        if ((localObject3 instanceof Double))
        {
          localContentValues.put(str, (Double)localObject3);
          continue;
        }
        if ((localObject3 instanceof Float))
        {
          localContentValues.put(str, (Float)localObject3);
          continue;
        }
        if ((localObject3 instanceof Byte))
        {
          localContentValues.put(str, (Byte)localObject3);
          continue;
        }
        if ((localObject3 instanceof Boolean)) {
          localContentValues.put(str, (Boolean)localObject3);
        }
      }
      if ((localObject3 instanceof List)) {
        localContentValues.putAll(a((List)localObject3, str + "."));
      }
    }
    return localContentValues;
  }
  
  private static ContentValues a(List paramList, String paramString)
  {
    ContentValues localContentValues = new ContentValues();
    if ((paramList != null) && (paramList.size() > 0))
    {
      localContentValues.put(paramString + "n", Integer.valueOf(paramList.size()));
      int i = 0;
      while (i < paramList.size())
      {
        localContentValues.put(paramString + i + ".-", ((Entity)paramList.get(i)).getClass().getName());
        localContentValues.putAll(a((Entity)paramList.get(i), paramString + i + "."));
        i += 1;
      }
    }
    return localContentValues;
  }
  
  public static Entity a(ContentValues paramContentValues, String paramString)
  {
    return a(paramContentValues, paramString, "");
  }
  
  private static Entity a(ContentValues paramContentValues, String paramString1, String paramString2)
  {
    try
    {
      Entity localEntity = (Entity)Class.forName(paramString1).newInstance();
      paramString1 = localEntity;
      if (localEntity != null)
      {
        paramString1 = a(localEntity).iterator();
        while (paramString1.hasNext())
        {
          Field localField = (Field)paramString1.next();
          Object localObject1 = paramString2 + localField.getName();
          Object localObject2 = localField.getType();
          if (Entity.class.isAssignableFrom((Class)localObject2))
          {
            localObject1 = a(paramContentValues, ((Class)localObject2).getName(), (String)localObject1 + ".");
            localEntity.setStatus(1002);
            localField.set(localEntity, localObject1);
          }
          else if (localObject2 == List.class)
          {
            int j = paramContentValues.getAsInteger((String)localObject1 + ".n").intValue();
            localObject2 = new ArrayList();
            int i = 0;
            while (i < j)
            {
              ((ArrayList)localObject2).add(a(paramContentValues, paramContentValues.getAsString((String)localObject1 + "." + i + ".-"), (String)localObject1 + "." + i + "."));
              i += 1;
            }
            localField.set(localEntity, localObject2);
          }
          else if (localObject2 == Long.TYPE)
          {
            localField.set(localEntity, paramContentValues.getAsLong((String)localObject1));
          }
          else if (localObject2 == Integer.TYPE)
          {
            localField.set(localEntity, paramContentValues.getAsInteger((String)localObject1));
          }
          else if (localObject2 == String.class)
          {
            localField.set(localEntity, paramContentValues.getAsString((String)localObject1));
          }
          else if (localObject2 == Byte.TYPE)
          {
            localField.set(localEntity, paramContentValues.getAsByte((String)localObject1));
          }
          else if (localObject2 == byte[].class)
          {
            localField.set(localEntity, paramContentValues.getAsByteArray((String)localObject1));
          }
          else if (localObject2 == Short.TYPE)
          {
            localField.set(localEntity, paramContentValues.getAsShort((String)localObject1));
          }
          else if (localObject2 == Boolean.TYPE)
          {
            localField.set(localEntity, paramContentValues.getAsBoolean((String)localObject1));
          }
          else if (localObject2 == Float.TYPE)
          {
            localField.set(localEntity, paramContentValues.getAsFloat((String)localObject1));
          }
          else if (localObject2 == Double.TYPE)
          {
            localField.set(localEntity, paramContentValues.getAsDouble((String)localObject1));
          }
        }
        if (localEntity.getId() != -1L)
        {
          localEntity.setStatus(1001);
          return localEntity;
        }
        localEntity.setStatus(1002);
        return localEntity;
      }
    }
    catch (Exception paramContentValues)
    {
      paramString1 = null;
    }
    return paramString1;
  }
  
  public static StructMsgItemImage a(StructMsgForImageShare paramStructMsgForImageShare)
  {
    if (paramStructMsgForImageShare.getItemCount() > 0)
    {
      paramStructMsgForImageShare = paramStructMsgForImageShare.getItemByIndex(0);
      if ((paramStructMsgForImageShare instanceof StructMsgItemLayoutDefault))
      {
        paramStructMsgForImageShare = (StructMsgItemLayoutDefault)paramStructMsgForImageShare;
        if ((paramStructMsgForImageShare.a.size() > 0) && ((paramStructMsgForImageShare.a.get(0) instanceof StructMsgItemImage))) {
          return (StructMsgItemImage)paramStructMsgForImageShare.a.get(0);
        }
      }
    }
    return null;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return paramString2;
    }
    return paramString1;
  }
  
  private static String a(Node paramNode)
  {
    if (paramNode.getNodeType() == 3) {}
    Object localObject;
    for (paramNode = paramNode.getNodeValue();; paramNode = ((StringBuilder)localObject).toString())
    {
      localObject = paramNode;
      if (paramNode == null) {
        localObject = "";
      }
      return (String)localObject;
      localObject = new StringBuilder();
      int j = paramNode.getChildNodes().getLength();
      int i = 0;
      if (i < j)
      {
        Node localNode = paramNode.getChildNodes().item(i);
        if (localNode == null) {}
        for (;;)
        {
          i += 1;
          break;
          if (localNode.getNodeType() == 3) {
            ((StringBuilder)localObject).append(localNode.getNodeValue());
          }
        }
      }
    }
  }
  
  private static List a(Entity paramEntity)
  {
    Class localClass = paramEntity.getClass();
    Object localObject1 = (List)a.get(localClass);
    paramEntity = (Entity)localObject1;
    if (localObject1 == null)
    {
      paramEntity = new ArrayList();
      localObject1 = localClass.getFields();
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        if (!Modifier.isStatic(((Field)localObject2).getModifiers())) {
          paramEntity.add(localObject2);
        }
        i += 1;
      }
      a.put(localClass.getName(), paramEntity);
    }
    return paramEntity;
  }
  
  public static void a(Activity paramActivity, String paramString, boolean paramBoolean)
  {
    QfavHelper.a(paramActivity, paramString, true, null, false);
  }
  
  public static void a(Context paramContext, int paramInt1, int paramInt2)
  {
    QQToast.a(paramContext, paramInt2, paramInt1, 2000).b(paramContext.getResources().getDimensionPixelSize(2131492908) - (int)DisplayUtils.a(paramContext, 5.0F));
  }
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    QQToast.a(paramContext, paramInt, paramString, 2000).b(paramContext.getResources().getDimensionPixelSize(2131492908) - (int)DisplayUtils.a(paramContext, 5.0F));
  }
  
  public static void a(String paramString)
  {
    Object localObject = BaseApplicationImpl.a();
    if (Build.VERSION.SDK_INT > 10) {}
    for (int i = 4;; i = 0)
    {
      localObject = ((BaseApplicationImpl)localObject).getSystemSharedPreferences("mobileQQ", i);
      String str = "qfav_click_red_point_" + paramString;
      if (!((SharedPreferences)localObject).getBoolean(str, false)) {
        ((SharedPreferences)localObject).edit().putBoolean(str, true).commit();
      }
      paramString = "favorites_entry_red_point_" + paramString;
      if (!((SharedPreferences)localObject).getBoolean(paramString, false)) {
        ((SharedPreferences)localObject).edit().putBoolean(paramString, true).commit();
      }
      return;
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    Object localObject = BaseApplicationImpl.a();
    if (Build.VERSION.SDK_INT > 10) {}
    for (int i = 4;; i = 0)
    {
      localObject = ((BaseApplicationImpl)localObject).getSharedPreferences("QfavEdit", i);
      if (localObject != null)
      {
        boolean bool = ((SharedPreferences)localObject).edit().putBoolean(BaseApplicationImpl.a.a().getAccount() + "QfavEdit", paramBoolean).commit();
        if (QLog.isColorLevel()) {
          QLog.i("qqfav", 2, "setEditFlag:" + paramBoolean + ",suc:" + bool);
        }
      }
      return;
    }
  }
  
  public static boolean a()
  {
    Object localObject = BaseApplicationImpl.a();
    if (Build.VERSION.SDK_INT > 10) {}
    for (int i = 4;; i = 0)
    {
      localObject = ((BaseApplicationImpl)localObject).getSharedPreferences("QfavEdit", i);
      if (localObject == null) {
        break;
      }
      return ((SharedPreferences)localObject).getBoolean(BaseApplicationImpl.a.a().getAccount() + "QfavEdit", false);
    }
    return true;
  }
  
  public static boolean a(Activity paramActivity)
  {
    if (!SystemUtil.a())
    {
      a(paramActivity, 2131362151, 1);
      return false;
    }
    if (SystemUtil.a() < 500L)
    {
      a(paramActivity, 2131362150, 1);
      return false;
    }
    return true;
  }
  
  public static boolean a(String paramString, long paramLong)
  {
    long l = paramLong;
    if (paramString != null)
    {
      l = paramLong;
      if (paramLong < 0L) {
        l = new File(paramString).length();
      }
    }
    return (paramString != null) && (l > 209715200L);
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      paramArrayOfByte = null;
    }
    int i;
    byte[] arrayOfByte;
    do
    {
      return paramArrayOfByte;
      i = paramArrayOfByte[0];
      arrayOfByte = new byte[paramArrayOfByte.length - 1];
      System.arraycopy(paramArrayOfByte, 1, arrayOfByte, 0, arrayOfByte.length);
      paramArrayOfByte = arrayOfByte;
    } while (i != 1);
    return StructMsgUtils.a(arrayOfByte);
  }
  
  /* Error */
  public static String[] a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: invokestatic 489	javax/xml/parsers/DocumentBuilderFactory:newInstance	()Ljavax/xml/parsers/DocumentBuilderFactory;
    //   5: astore_2
    //   6: aload_2
    //   7: invokevirtual 493	javax/xml/parsers/DocumentBuilderFactory:newDocumentBuilder	()Ljavax/xml/parsers/DocumentBuilder;
    //   10: new 495	java/io/ByteArrayInputStream
    //   13: dup
    //   14: aload_0
    //   15: invokespecial 498	java/io/ByteArrayInputStream:<init>	([B)V
    //   18: invokevirtual 504	javax/xml/parsers/DocumentBuilder:parse	(Ljava/io/InputStream;)Lorg/w3c/dom/Document;
    //   21: invokeinterface 510 1 0
    //   26: astore_2
    //   27: aload_1
    //   28: astore_0
    //   29: aconst_null
    //   30: invokestatic 288	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   33: ifeq +13 -> 46
    //   36: aload_2
    //   37: ldc_w 512
    //   40: invokeinterface 517 2 0
    //   45: astore_0
    //   46: aload_2
    //   47: invokeinterface 518 1 0
    //   52: astore 23
    //   54: aload 23
    //   56: invokeinterface 307 1 0
    //   61: istore 28
    //   63: iconst_0
    //   64: istore 26
    //   66: aconst_null
    //   67: astore_1
    //   68: aconst_null
    //   69: astore_2
    //   70: aconst_null
    //   71: astore_3
    //   72: aconst_null
    //   73: astore 5
    //   75: aconst_null
    //   76: astore 4
    //   78: iload 26
    //   80: iload 28
    //   82: if_icmpge +1442 -> 1524
    //   85: aload_1
    //   86: astore 13
    //   88: aload_2
    //   89: astore 7
    //   91: aload_3
    //   92: astore 10
    //   94: aload 4
    //   96: astore 16
    //   98: aload_1
    //   99: astore 14
    //   101: aload_2
    //   102: astore 8
    //   104: aload_3
    //   105: astore 11
    //   107: aload 4
    //   109: astore 17
    //   111: aload_1
    //   112: astore 15
    //   114: aload_2
    //   115: astore 9
    //   117: aload_3
    //   118: astore 12
    //   120: aload 4
    //   122: astore 18
    //   124: aload 23
    //   126: iload 26
    //   128: invokeinterface 311 2 0
    //   133: astore 24
    //   135: aload_1
    //   136: astore 13
    //   138: aload_2
    //   139: astore 7
    //   141: aload_3
    //   142: astore 10
    //   144: aload 4
    //   146: astore 16
    //   148: aload_1
    //   149: astore 14
    //   151: aload_2
    //   152: astore 8
    //   154: aload_3
    //   155: astore 11
    //   157: aload 4
    //   159: astore 17
    //   161: aload_1
    //   162: astore 15
    //   164: aload_2
    //   165: astore 9
    //   167: aload_3
    //   168: astore 12
    //   170: aload 4
    //   172: astore 18
    //   174: aload 24
    //   176: invokeinterface 521 1 0
    //   181: astore 25
    //   183: aload_1
    //   184: astore 13
    //   186: aload_2
    //   187: astore 7
    //   189: aload_3
    //   190: astore 10
    //   192: aload 4
    //   194: astore 16
    //   196: aload_1
    //   197: astore 14
    //   199: aload_2
    //   200: astore 8
    //   202: aload_3
    //   203: astore 11
    //   205: aload 4
    //   207: astore 17
    //   209: aload_1
    //   210: astore 15
    //   212: aload_2
    //   213: astore 9
    //   215: aload_3
    //   216: astore 12
    //   218: aload 4
    //   220: astore 18
    //   222: aload 25
    //   224: ldc_w 522
    //   227: invokevirtual 525	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   230: ifeq +1063 -> 1293
    //   233: aload_1
    //   234: astore 13
    //   236: aload_2
    //   237: astore 7
    //   239: aload_3
    //   240: astore 10
    //   242: aload 4
    //   244: astore 16
    //   246: aload_1
    //   247: astore 14
    //   249: aload_2
    //   250: astore 8
    //   252: aload_3
    //   253: astore 11
    //   255: aload 4
    //   257: astore 17
    //   259: aload_1
    //   260: astore 15
    //   262: aload_2
    //   263: astore 9
    //   265: aload_3
    //   266: astore 12
    //   268: aload 4
    //   270: astore 18
    //   272: aload 24
    //   274: invokeinterface 302 1 0
    //   279: astore 24
    //   281: iconst_0
    //   282: istore 27
    //   284: aload_1
    //   285: astore 19
    //   287: aload_2
    //   288: astore 20
    //   290: aload_3
    //   291: astore 21
    //   293: aload 5
    //   295: astore 22
    //   297: aload 4
    //   299: astore 6
    //   301: aload_1
    //   302: astore 13
    //   304: aload_2
    //   305: astore 7
    //   307: aload_3
    //   308: astore 10
    //   310: aload 4
    //   312: astore 16
    //   314: aload_1
    //   315: astore 14
    //   317: aload_2
    //   318: astore 8
    //   320: aload_3
    //   321: astore 11
    //   323: aload 4
    //   325: astore 17
    //   327: aload_1
    //   328: astore 15
    //   330: aload_2
    //   331: astore 9
    //   333: aload_3
    //   334: astore 12
    //   336: aload 4
    //   338: astore 18
    //   340: iload 27
    //   342: aload 24
    //   344: invokeinterface 307 1 0
    //   349: if_icmpge +1149 -> 1498
    //   352: aload_1
    //   353: astore 13
    //   355: aload_2
    //   356: astore 7
    //   358: aload_3
    //   359: astore 10
    //   361: aload 4
    //   363: astore 16
    //   365: aload_1
    //   366: astore 14
    //   368: aload_2
    //   369: astore 8
    //   371: aload_3
    //   372: astore 11
    //   374: aload 4
    //   376: astore 17
    //   378: aload_1
    //   379: astore 15
    //   381: aload_2
    //   382: astore 9
    //   384: aload_3
    //   385: astore 12
    //   387: aload 4
    //   389: astore 18
    //   391: aload 24
    //   393: iload 27
    //   395: invokeinterface 311 2 0
    //   400: astore 6
    //   402: aload_1
    //   403: astore 13
    //   405: aload_2
    //   406: astore 7
    //   408: aload_3
    //   409: astore 10
    //   411: aload 4
    //   413: astore 16
    //   415: aload_1
    //   416: astore 14
    //   418: aload_2
    //   419: astore 8
    //   421: aload_3
    //   422: astore 11
    //   424: aload 4
    //   426: astore 17
    //   428: aload_1
    //   429: astore 15
    //   431: aload_2
    //   432: astore 9
    //   434: aload_3
    //   435: astore 12
    //   437: aload 4
    //   439: astore 18
    //   441: aload 6
    //   443: invokeinterface 521 1 0
    //   448: ldc_w 527
    //   451: invokevirtual 525	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   454: ifeq +136 -> 590
    //   457: aload_1
    //   458: astore 13
    //   460: aload_2
    //   461: astore 7
    //   463: aload_3
    //   464: astore 10
    //   466: aload 4
    //   468: astore 16
    //   470: aload_1
    //   471: astore 14
    //   473: aload_2
    //   474: astore 8
    //   476: aload_3
    //   477: astore 11
    //   479: aload 4
    //   481: astore 17
    //   483: aload_1
    //   484: astore 15
    //   486: aload_2
    //   487: astore 9
    //   489: aload_3
    //   490: astore 12
    //   492: aload 4
    //   494: astore 18
    //   496: aload_1
    //   497: astore 20
    //   499: aload_2
    //   500: astore 19
    //   502: aload_3
    //   503: astore 21
    //   505: aload 4
    //   507: astore 22
    //   509: aload_2
    //   510: invokestatic 288	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   513: ifeq +1259 -> 1772
    //   516: aload_1
    //   517: astore 13
    //   519: aload_2
    //   520: astore 7
    //   522: aload_3
    //   523: astore 10
    //   525: aload 4
    //   527: astore 16
    //   529: aload_1
    //   530: astore 14
    //   532: aload_2
    //   533: astore 8
    //   535: aload_3
    //   536: astore 11
    //   538: aload 4
    //   540: astore 17
    //   542: aload_1
    //   543: astore 15
    //   545: aload_2
    //   546: astore 9
    //   548: aload_3
    //   549: astore 12
    //   551: aload 4
    //   553: astore 18
    //   555: aload 6
    //   557: invokeinterface 531 1 0
    //   562: ldc_w 533
    //   565: invokeinterface 539 2 0
    //   570: invokeinterface 298 1 0
    //   575: astore 19
    //   577: aload_1
    //   578: astore 20
    //   580: aload_3
    //   581: astore 21
    //   583: aload 4
    //   585: astore 22
    //   587: goto +1185 -> 1772
    //   590: aload_1
    //   591: astore 13
    //   593: aload_2
    //   594: astore 7
    //   596: aload_3
    //   597: astore 10
    //   599: aload 4
    //   601: astore 16
    //   603: aload_1
    //   604: astore 14
    //   606: aload_2
    //   607: astore 8
    //   609: aload_3
    //   610: astore 11
    //   612: aload 4
    //   614: astore 17
    //   616: aload_1
    //   617: astore 15
    //   619: aload_2
    //   620: astore 9
    //   622: aload_3
    //   623: astore 12
    //   625: aload 4
    //   627: astore 18
    //   629: aload 6
    //   631: invokeinterface 521 1 0
    //   636: ldc_w 541
    //   639: invokevirtual 525	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   642: ifeq +121 -> 763
    //   645: aload_1
    //   646: astore 13
    //   648: aload_2
    //   649: astore 7
    //   651: aload_3
    //   652: astore 10
    //   654: aload 4
    //   656: astore 16
    //   658: aload_1
    //   659: astore 14
    //   661: aload_2
    //   662: astore 8
    //   664: aload_3
    //   665: astore 11
    //   667: aload 4
    //   669: astore 17
    //   671: aload_1
    //   672: astore 15
    //   674: aload_2
    //   675: astore 9
    //   677: aload_3
    //   678: astore 12
    //   680: aload 4
    //   682: astore 18
    //   684: aload_1
    //   685: astore 20
    //   687: aload_2
    //   688: astore 19
    //   690: aload_3
    //   691: astore 21
    //   693: aload 4
    //   695: astore 22
    //   697: aload 4
    //   699: invokestatic 288	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   702: ifeq +1070 -> 1772
    //   705: aload_1
    //   706: astore 13
    //   708: aload_2
    //   709: astore 7
    //   711: aload_3
    //   712: astore 10
    //   714: aload 4
    //   716: astore 16
    //   718: aload_1
    //   719: astore 14
    //   721: aload_2
    //   722: astore 8
    //   724: aload_3
    //   725: astore 11
    //   727: aload 4
    //   729: astore 17
    //   731: aload_1
    //   732: astore 15
    //   734: aload_2
    //   735: astore 9
    //   737: aload_3
    //   738: astore 12
    //   740: aload 4
    //   742: astore 18
    //   744: aload 6
    //   746: invokestatic 543	cooperation/qqfav/QfavUtil:a	(Lorg/w3c/dom/Node;)Ljava/lang/String;
    //   749: astore 22
    //   751: aload_1
    //   752: astore 20
    //   754: aload_2
    //   755: astore 19
    //   757: aload_3
    //   758: astore 21
    //   760: goto +1012 -> 1772
    //   763: aload_1
    //   764: astore 13
    //   766: aload_2
    //   767: astore 7
    //   769: aload_3
    //   770: astore 10
    //   772: aload 4
    //   774: astore 16
    //   776: aload_1
    //   777: astore 14
    //   779: aload_2
    //   780: astore 8
    //   782: aload_3
    //   783: astore 11
    //   785: aload 4
    //   787: astore 17
    //   789: aload_1
    //   790: astore 15
    //   792: aload_2
    //   793: astore 9
    //   795: aload_3
    //   796: astore 12
    //   798: aload 4
    //   800: astore 18
    //   802: aload 6
    //   804: invokeinterface 521 1 0
    //   809: ldc_w 545
    //   812: invokevirtual 525	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   815: ifeq +121 -> 936
    //   818: aload_1
    //   819: astore 13
    //   821: aload_2
    //   822: astore 7
    //   824: aload_3
    //   825: astore 10
    //   827: aload 4
    //   829: astore 16
    //   831: aload_1
    //   832: astore 14
    //   834: aload_2
    //   835: astore 8
    //   837: aload_3
    //   838: astore 11
    //   840: aload 4
    //   842: astore 17
    //   844: aload_1
    //   845: astore 15
    //   847: aload_2
    //   848: astore 9
    //   850: aload_3
    //   851: astore 12
    //   853: aload 4
    //   855: astore 18
    //   857: aload_1
    //   858: astore 20
    //   860: aload_2
    //   861: astore 19
    //   863: aload_3
    //   864: astore 21
    //   866: aload 4
    //   868: astore 22
    //   870: aload_3
    //   871: invokestatic 288	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   874: ifeq +898 -> 1772
    //   877: aload_1
    //   878: astore 13
    //   880: aload_2
    //   881: astore 7
    //   883: aload_3
    //   884: astore 10
    //   886: aload 4
    //   888: astore 16
    //   890: aload_1
    //   891: astore 14
    //   893: aload_2
    //   894: astore 8
    //   896: aload_3
    //   897: astore 11
    //   899: aload 4
    //   901: astore 17
    //   903: aload_1
    //   904: astore 15
    //   906: aload_2
    //   907: astore 9
    //   909: aload_3
    //   910: astore 12
    //   912: aload 4
    //   914: astore 18
    //   916: aload 6
    //   918: invokestatic 543	cooperation/qqfav/QfavUtil:a	(Lorg/w3c/dom/Node;)Ljava/lang/String;
    //   921: astore 21
    //   923: aload_1
    //   924: astore 20
    //   926: aload_2
    //   927: astore 19
    //   929: aload 4
    //   931: astore 22
    //   933: goto +839 -> 1772
    //   936: aload_1
    //   937: astore 13
    //   939: aload_2
    //   940: astore 7
    //   942: aload_3
    //   943: astore 10
    //   945: aload 4
    //   947: astore 16
    //   949: aload_1
    //   950: astore 14
    //   952: aload_2
    //   953: astore 8
    //   955: aload_3
    //   956: astore 11
    //   958: aload 4
    //   960: astore 17
    //   962: aload_1
    //   963: astore 15
    //   965: aload_2
    //   966: astore 9
    //   968: aload_3
    //   969: astore 12
    //   971: aload 4
    //   973: astore 18
    //   975: aload_1
    //   976: astore 20
    //   978: aload_2
    //   979: astore 19
    //   981: aload_3
    //   982: astore 21
    //   984: aload 4
    //   986: astore 22
    //   988: aload 6
    //   990: invokeinterface 521 1 0
    //   995: ldc_w 547
    //   998: invokevirtual 525	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1001: ifeq +771 -> 1772
    //   1004: aload_1
    //   1005: astore 13
    //   1007: aload_2
    //   1008: astore 7
    //   1010: aload_3
    //   1011: astore 10
    //   1013: aload 4
    //   1015: astore 16
    //   1017: aload_1
    //   1018: astore 14
    //   1020: aload_2
    //   1021: astore 8
    //   1023: aload_3
    //   1024: astore 11
    //   1026: aload 4
    //   1028: astore 17
    //   1030: aload_1
    //   1031: astore 15
    //   1033: aload_2
    //   1034: astore 9
    //   1036: aload_3
    //   1037: astore 12
    //   1039: aload 4
    //   1041: astore 18
    //   1043: aload 6
    //   1045: invokeinterface 531 1 0
    //   1050: astore 25
    //   1052: aload_2
    //   1053: astore 6
    //   1055: aload_1
    //   1056: astore 13
    //   1058: aload_2
    //   1059: astore 7
    //   1061: aload_3
    //   1062: astore 10
    //   1064: aload 4
    //   1066: astore 16
    //   1068: aload_1
    //   1069: astore 14
    //   1071: aload_2
    //   1072: astore 8
    //   1074: aload_3
    //   1075: astore 11
    //   1077: aload 4
    //   1079: astore 17
    //   1081: aload_1
    //   1082: astore 15
    //   1084: aload_2
    //   1085: astore 9
    //   1087: aload_3
    //   1088: astore 12
    //   1090: aload 4
    //   1092: astore 18
    //   1094: aload_2
    //   1095: invokestatic 288	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1098: ifeq +59 -> 1157
    //   1101: aload_1
    //   1102: astore 13
    //   1104: aload_2
    //   1105: astore 7
    //   1107: aload_3
    //   1108: astore 10
    //   1110: aload 4
    //   1112: astore 16
    //   1114: aload_1
    //   1115: astore 14
    //   1117: aload_2
    //   1118: astore 8
    //   1120: aload_3
    //   1121: astore 11
    //   1123: aload 4
    //   1125: astore 17
    //   1127: aload_1
    //   1128: astore 15
    //   1130: aload_2
    //   1131: astore 9
    //   1133: aload_3
    //   1134: astore 12
    //   1136: aload 4
    //   1138: astore 18
    //   1140: aload 25
    //   1142: ldc_w 533
    //   1145: invokeinterface 539 2 0
    //   1150: invokeinterface 298 1 0
    //   1155: astore 6
    //   1157: aload_1
    //   1158: astore 13
    //   1160: aload 6
    //   1162: astore 7
    //   1164: aload_3
    //   1165: astore 10
    //   1167: aload 4
    //   1169: astore 16
    //   1171: aload_1
    //   1172: astore 14
    //   1174: aload 6
    //   1176: astore 8
    //   1178: aload_3
    //   1179: astore 11
    //   1181: aload 4
    //   1183: astore 17
    //   1185: aload_1
    //   1186: astore 15
    //   1188: aload 6
    //   1190: astore 9
    //   1192: aload_3
    //   1193: astore 12
    //   1195: aload 4
    //   1197: astore 18
    //   1199: aload_1
    //   1200: astore 20
    //   1202: aload 6
    //   1204: astore 19
    //   1206: aload_3
    //   1207: astore 21
    //   1209: aload 4
    //   1211: astore 22
    //   1213: aload_1
    //   1214: invokestatic 288	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1217: ifeq +555 -> 1772
    //   1220: aload_1
    //   1221: astore 13
    //   1223: aload 6
    //   1225: astore 7
    //   1227: aload_3
    //   1228: astore 10
    //   1230: aload 4
    //   1232: astore 16
    //   1234: aload_1
    //   1235: astore 14
    //   1237: aload 6
    //   1239: astore 8
    //   1241: aload_3
    //   1242: astore 11
    //   1244: aload 4
    //   1246: astore 17
    //   1248: aload_1
    //   1249: astore 15
    //   1251: aload 6
    //   1253: astore 9
    //   1255: aload_3
    //   1256: astore 12
    //   1258: aload 4
    //   1260: astore 18
    //   1262: aload 25
    //   1264: ldc_w 549
    //   1267: invokeinterface 539 2 0
    //   1272: invokeinterface 298 1 0
    //   1277: astore 20
    //   1279: aload 6
    //   1281: astore 19
    //   1283: aload_3
    //   1284: astore 21
    //   1286: aload 4
    //   1288: astore 22
    //   1290: goto +482 -> 1772
    //   1293: aload_1
    //   1294: astore 19
    //   1296: aload_2
    //   1297: astore 20
    //   1299: aload_3
    //   1300: astore 21
    //   1302: aload 5
    //   1304: astore 22
    //   1306: aload 4
    //   1308: astore 6
    //   1310: aload_1
    //   1311: astore 13
    //   1313: aload_2
    //   1314: astore 7
    //   1316: aload_3
    //   1317: astore 10
    //   1319: aload 4
    //   1321: astore 16
    //   1323: aload_1
    //   1324: astore 14
    //   1326: aload_2
    //   1327: astore 8
    //   1329: aload_3
    //   1330: astore 11
    //   1332: aload 4
    //   1334: astore 17
    //   1336: aload_1
    //   1337: astore 15
    //   1339: aload_2
    //   1340: astore 9
    //   1342: aload_3
    //   1343: astore 12
    //   1345: aload 4
    //   1347: astore 18
    //   1349: aload 25
    //   1351: ldc_w 551
    //   1354: invokevirtual 525	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1357: ifeq +141 -> 1498
    //   1360: aload_1
    //   1361: astore 19
    //   1363: aload_2
    //   1364: astore 20
    //   1366: aload_3
    //   1367: astore 21
    //   1369: aload 5
    //   1371: astore 22
    //   1373: aload 4
    //   1375: astore 6
    //   1377: aload_1
    //   1378: astore 13
    //   1380: aload_2
    //   1381: astore 7
    //   1383: aload_3
    //   1384: astore 10
    //   1386: aload 4
    //   1388: astore 16
    //   1390: aload_1
    //   1391: astore 14
    //   1393: aload_2
    //   1394: astore 8
    //   1396: aload_3
    //   1397: astore 11
    //   1399: aload 4
    //   1401: astore 17
    //   1403: aload_1
    //   1404: astore 15
    //   1406: aload_2
    //   1407: astore 9
    //   1409: aload_3
    //   1410: astore 12
    //   1412: aload 4
    //   1414: astore 18
    //   1416: aload 5
    //   1418: invokestatic 288	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1421: ifeq +77 -> 1498
    //   1424: aload_1
    //   1425: astore 13
    //   1427: aload_2
    //   1428: astore 7
    //   1430: aload_3
    //   1431: astore 10
    //   1433: aload 4
    //   1435: astore 16
    //   1437: aload_1
    //   1438: astore 14
    //   1440: aload_2
    //   1441: astore 8
    //   1443: aload_3
    //   1444: astore 11
    //   1446: aload 4
    //   1448: astore 17
    //   1450: aload_1
    //   1451: astore 15
    //   1453: aload_2
    //   1454: astore 9
    //   1456: aload_3
    //   1457: astore 12
    //   1459: aload 4
    //   1461: astore 18
    //   1463: aload 24
    //   1465: invokeinterface 531 1 0
    //   1470: ldc_w 553
    //   1473: invokeinterface 539 2 0
    //   1478: invokeinterface 298 1 0
    //   1483: astore 22
    //   1485: aload 4
    //   1487: astore 6
    //   1489: aload_3
    //   1490: astore 21
    //   1492: aload_2
    //   1493: astore 20
    //   1495: aload_1
    //   1496: astore 19
    //   1498: iload 26
    //   1500: iconst_1
    //   1501: iadd
    //   1502: istore 26
    //   1504: aload 19
    //   1506: astore_1
    //   1507: aload 20
    //   1509: astore_2
    //   1510: aload 21
    //   1512: astore_3
    //   1513: aload 22
    //   1515: astore 5
    //   1517: aload 6
    //   1519: astore 4
    //   1521: goto -1443 -> 78
    //   1524: aload_0
    //   1525: astore 6
    //   1527: aload_3
    //   1528: astore_0
    //   1529: bipush 6
    //   1531: anewarray 107	java/lang/String
    //   1534: dup
    //   1535: iconst_0
    //   1536: aload 4
    //   1538: aastore
    //   1539: dup
    //   1540: iconst_1
    //   1541: aload 6
    //   1543: aastore
    //   1544: dup
    //   1545: iconst_2
    //   1546: aload 5
    //   1548: aastore
    //   1549: dup
    //   1550: iconst_3
    //   1551: aload_0
    //   1552: aastore
    //   1553: dup
    //   1554: iconst_4
    //   1555: aload_2
    //   1556: aastore
    //   1557: dup
    //   1558: iconst_5
    //   1559: aload_1
    //   1560: aastore
    //   1561: areturn
    //   1562: astore 6
    //   1564: aconst_null
    //   1565: astore_1
    //   1566: aconst_null
    //   1567: astore_2
    //   1568: aconst_null
    //   1569: astore_0
    //   1570: aconst_null
    //   1571: astore 5
    //   1573: aconst_null
    //   1574: astore_3
    //   1575: aconst_null
    //   1576: astore 4
    //   1578: aload 6
    //   1580: invokevirtual 554	javax/xml/parsers/ParserConfigurationException:printStackTrace	()V
    //   1583: aload_3
    //   1584: astore 6
    //   1586: goto -57 -> 1529
    //   1589: astore 6
    //   1591: aconst_null
    //   1592: astore_1
    //   1593: aconst_null
    //   1594: astore_2
    //   1595: aconst_null
    //   1596: astore_0
    //   1597: aconst_null
    //   1598: astore 5
    //   1600: aconst_null
    //   1601: astore_3
    //   1602: aconst_null
    //   1603: astore 4
    //   1605: aload 6
    //   1607: invokevirtual 555	org/xml/sax/SAXException:printStackTrace	()V
    //   1610: aload_3
    //   1611: astore 6
    //   1613: goto -84 -> 1529
    //   1616: astore 6
    //   1618: aconst_null
    //   1619: astore_1
    //   1620: aconst_null
    //   1621: astore_2
    //   1622: aconst_null
    //   1623: astore_0
    //   1624: aconst_null
    //   1625: astore 5
    //   1627: aconst_null
    //   1628: astore_3
    //   1629: aconst_null
    //   1630: astore 4
    //   1632: aload 6
    //   1634: invokevirtual 556	java/io/IOException:printStackTrace	()V
    //   1637: aload_3
    //   1638: astore 6
    //   1640: goto -111 -> 1529
    //   1643: astore 6
    //   1645: aconst_null
    //   1646: astore_1
    //   1647: aconst_null
    //   1648: astore_2
    //   1649: aconst_null
    //   1650: astore 7
    //   1652: aconst_null
    //   1653: astore 5
    //   1655: aload_0
    //   1656: astore_3
    //   1657: aconst_null
    //   1658: astore 4
    //   1660: aload 7
    //   1662: astore_0
    //   1663: goto -31 -> 1632
    //   1666: astore 6
    //   1668: aload 16
    //   1670: astore 4
    //   1672: aload_0
    //   1673: astore_3
    //   1674: aload 13
    //   1676: astore_1
    //   1677: aload 7
    //   1679: astore_2
    //   1680: aload 10
    //   1682: astore_0
    //   1683: goto -51 -> 1632
    //   1686: astore 6
    //   1688: aconst_null
    //   1689: astore_1
    //   1690: aconst_null
    //   1691: astore_2
    //   1692: aconst_null
    //   1693: astore 7
    //   1695: aconst_null
    //   1696: astore 5
    //   1698: aload_0
    //   1699: astore_3
    //   1700: aconst_null
    //   1701: astore 4
    //   1703: aload 7
    //   1705: astore_0
    //   1706: goto -101 -> 1605
    //   1709: astore 6
    //   1711: aload 17
    //   1713: astore 4
    //   1715: aload_0
    //   1716: astore_3
    //   1717: aload 14
    //   1719: astore_1
    //   1720: aload 8
    //   1722: astore_2
    //   1723: aload 11
    //   1725: astore_0
    //   1726: goto -121 -> 1605
    //   1729: astore 6
    //   1731: aconst_null
    //   1732: astore_1
    //   1733: aconst_null
    //   1734: astore_2
    //   1735: aconst_null
    //   1736: astore 7
    //   1738: aconst_null
    //   1739: astore 5
    //   1741: aload_0
    //   1742: astore_3
    //   1743: aconst_null
    //   1744: astore 4
    //   1746: aload 7
    //   1748: astore_0
    //   1749: goto -171 -> 1578
    //   1752: astore 6
    //   1754: aload 18
    //   1756: astore 4
    //   1758: aload_0
    //   1759: astore_3
    //   1760: aload 15
    //   1762: astore_1
    //   1763: aload 9
    //   1765: astore_2
    //   1766: aload 12
    //   1768: astore_0
    //   1769: goto -191 -> 1578
    //   1772: iload 27
    //   1774: iconst_1
    //   1775: iadd
    //   1776: istore 27
    //   1778: aload 20
    //   1780: astore_1
    //   1781: aload 19
    //   1783: astore_2
    //   1784: aload 21
    //   1786: astore_3
    //   1787: aload 22
    //   1789: astore 4
    //   1791: goto -1507 -> 284
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1794	0	paramArrayOfByte	byte[]
    //   1	1780	1	localObject1	Object
    //   5	1779	2	localObject2	Object
    //   71	1716	3	localObject3	Object
    //   76	1714	4	localObject4	Object
    //   73	1667	5	localObject5	Object
    //   299	1243	6	localObject6	Object
    //   1562	17	6	localParserConfigurationException1	javax.xml.parsers.ParserConfigurationException
    //   1584	1	6	localObject7	Object
    //   1589	17	6	localSAXException1	org.xml.sax.SAXException
    //   1611	1	6	localObject8	Object
    //   1616	17	6	localIOException1	java.io.IOException
    //   1638	1	6	localObject9	Object
    //   1643	1	6	localIOException2	java.io.IOException
    //   1666	1	6	localIOException3	java.io.IOException
    //   1686	1	6	localSAXException2	org.xml.sax.SAXException
    //   1709	1	6	localSAXException3	org.xml.sax.SAXException
    //   1729	1	6	localParserConfigurationException2	javax.xml.parsers.ParserConfigurationException
    //   1752	1	6	localParserConfigurationException3	javax.xml.parsers.ParserConfigurationException
    //   89	1658	7	localObject10	Object
    //   102	1619	8	localObject11	Object
    //   115	1649	9	localObject12	Object
    //   92	1589	10	localObject13	Object
    //   105	1619	11	localObject14	Object
    //   118	1649	12	localObject15	Object
    //   86	1589	13	localObject16	Object
    //   99	1619	14	localObject17	Object
    //   112	1649	15	localObject18	Object
    //   96	1573	16	localObject19	Object
    //   109	1603	17	localObject20	Object
    //   122	1633	18	localObject21	Object
    //   285	1497	19	localObject22	Object
    //   288	1491	20	localObject23	Object
    //   291	1494	21	localObject24	Object
    //   295	1493	22	localObject25	Object
    //   52	73	23	localNodeList	NodeList
    //   133	1331	24	localObject26	Object
    //   181	1169	25	localObject27	Object
    //   64	1439	26	i	int
    //   282	1495	27	j	int
    //   61	22	28	k	int
    // Exception table:
    //   from	to	target	type
    //   6	27	1562	javax/xml/parsers/ParserConfigurationException
    //   29	46	1562	javax/xml/parsers/ParserConfigurationException
    //   6	27	1589	org/xml/sax/SAXException
    //   29	46	1589	org/xml/sax/SAXException
    //   6	27	1616	java/io/IOException
    //   29	46	1616	java/io/IOException
    //   46	63	1643	java/io/IOException
    //   124	135	1666	java/io/IOException
    //   174	183	1666	java/io/IOException
    //   222	233	1666	java/io/IOException
    //   272	281	1666	java/io/IOException
    //   340	352	1666	java/io/IOException
    //   391	402	1666	java/io/IOException
    //   441	457	1666	java/io/IOException
    //   509	516	1666	java/io/IOException
    //   555	577	1666	java/io/IOException
    //   629	645	1666	java/io/IOException
    //   697	705	1666	java/io/IOException
    //   744	751	1666	java/io/IOException
    //   802	818	1666	java/io/IOException
    //   870	877	1666	java/io/IOException
    //   916	923	1666	java/io/IOException
    //   988	1004	1666	java/io/IOException
    //   1043	1052	1666	java/io/IOException
    //   1094	1101	1666	java/io/IOException
    //   1140	1157	1666	java/io/IOException
    //   1213	1220	1666	java/io/IOException
    //   1262	1279	1666	java/io/IOException
    //   1349	1360	1666	java/io/IOException
    //   1416	1424	1666	java/io/IOException
    //   1463	1485	1666	java/io/IOException
    //   46	63	1686	org/xml/sax/SAXException
    //   124	135	1709	org/xml/sax/SAXException
    //   174	183	1709	org/xml/sax/SAXException
    //   222	233	1709	org/xml/sax/SAXException
    //   272	281	1709	org/xml/sax/SAXException
    //   340	352	1709	org/xml/sax/SAXException
    //   391	402	1709	org/xml/sax/SAXException
    //   441	457	1709	org/xml/sax/SAXException
    //   509	516	1709	org/xml/sax/SAXException
    //   555	577	1709	org/xml/sax/SAXException
    //   629	645	1709	org/xml/sax/SAXException
    //   697	705	1709	org/xml/sax/SAXException
    //   744	751	1709	org/xml/sax/SAXException
    //   802	818	1709	org/xml/sax/SAXException
    //   870	877	1709	org/xml/sax/SAXException
    //   916	923	1709	org/xml/sax/SAXException
    //   988	1004	1709	org/xml/sax/SAXException
    //   1043	1052	1709	org/xml/sax/SAXException
    //   1094	1101	1709	org/xml/sax/SAXException
    //   1140	1157	1709	org/xml/sax/SAXException
    //   1213	1220	1709	org/xml/sax/SAXException
    //   1262	1279	1709	org/xml/sax/SAXException
    //   1349	1360	1709	org/xml/sax/SAXException
    //   1416	1424	1709	org/xml/sax/SAXException
    //   1463	1485	1709	org/xml/sax/SAXException
    //   46	63	1729	javax/xml/parsers/ParserConfigurationException
    //   124	135	1752	javax/xml/parsers/ParserConfigurationException
    //   174	183	1752	javax/xml/parsers/ParserConfigurationException
    //   222	233	1752	javax/xml/parsers/ParserConfigurationException
    //   272	281	1752	javax/xml/parsers/ParserConfigurationException
    //   340	352	1752	javax/xml/parsers/ParserConfigurationException
    //   391	402	1752	javax/xml/parsers/ParserConfigurationException
    //   441	457	1752	javax/xml/parsers/ParserConfigurationException
    //   509	516	1752	javax/xml/parsers/ParserConfigurationException
    //   555	577	1752	javax/xml/parsers/ParserConfigurationException
    //   629	645	1752	javax/xml/parsers/ParserConfigurationException
    //   697	705	1752	javax/xml/parsers/ParserConfigurationException
    //   744	751	1752	javax/xml/parsers/ParserConfigurationException
    //   802	818	1752	javax/xml/parsers/ParserConfigurationException
    //   870	877	1752	javax/xml/parsers/ParserConfigurationException
    //   916	923	1752	javax/xml/parsers/ParserConfigurationException
    //   988	1004	1752	javax/xml/parsers/ParserConfigurationException
    //   1043	1052	1752	javax/xml/parsers/ParserConfigurationException
    //   1094	1101	1752	javax/xml/parsers/ParserConfigurationException
    //   1140	1157	1752	javax/xml/parsers/ParserConfigurationException
    //   1213	1220	1752	javax/xml/parsers/ParserConfigurationException
    //   1262	1279	1752	javax/xml/parsers/ParserConfigurationException
    //   1349	1360	1752	javax/xml/parsers/ParserConfigurationException
    //   1416	1424	1752	javax/xml/parsers/ParserConfigurationException
    //   1463	1485	1752	javax/xml/parsers/ParserConfigurationException
  }
  
  public static int b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 3;
    case 1: 
      return 4;
    }
    return 5;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qqfav\QfavUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */