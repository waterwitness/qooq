package com.tencent.mobileqq.nearby.flat.canvas;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;

public class UIElementInflater
{
  static UIElementInflater jdField_a_of_type_ComTencentMobileqqNearbyFlatCanvasUIElementInflater;
  static final String jdField_a_of_type_JavaLangString = "UIElementInflater";
  static final HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  static final boolean jdField_a_of_type_Boolean = false;
  static final Class[] jdField_a_of_type_ArrayOfJavaLangClass;
  static final String b = "merge";
  final Context jdField_a_of_type_AndroidContentContext;
  final Object[] jdField_a_of_type_ArrayOfJavaLangObject = new Object[2];
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_ArrayOfJavaLangClass = new Class[] { UIElementHost.class, AttributeSet.class };
  }
  
  protected UIElementInflater(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public static UIElementInflater a(Context paramContext)
  {
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqNearbyFlatCanvasUIElementInflater == null) {
        jdField_a_of_type_ComTencentMobileqqNearbyFlatCanvasUIElementInflater = new UIElementInflater(paramContext.getApplicationContext());
      }
      paramContext = jdField_a_of_type_ComTencentMobileqqNearbyFlatCanvasUIElementInflater;
      return paramContext;
    }
    finally {}
  }
  
  public Context a()
  {
    return this.jdField_a_of_type_AndroidContentContext;
  }
  
  public UIElement a(int paramInt, UIElementHost paramUIElementHost, UIElementGroup paramUIElementGroup)
  {
    if (paramUIElementGroup != null) {}
    for (boolean bool = true;; bool = false) {
      return a(paramInt, paramUIElementHost, paramUIElementGroup, bool);
    }
  }
  
  public UIElement a(int paramInt, UIElementHost paramUIElementHost, UIElementGroup paramUIElementGroup, boolean paramBoolean)
  {
    UIElement localUIElement = null;
    XmlResourceParser localXmlResourceParser = a().getResources().getLayout(paramInt);
    if (localXmlResourceParser != null) {}
    try
    {
      localUIElement = a(localXmlResourceParser, paramUIElementHost, paramUIElementGroup, paramBoolean);
      return localUIElement;
    }
    finally
    {
      localXmlResourceParser.close();
    }
  }
  
  protected UIElement a(UIElement paramUIElement, String paramString, AttributeSet paramAttributeSet)
  {
    return a(paramString, paramAttributeSet);
  }
  
  protected UIElement a(String paramString, AttributeSet paramAttributeSet)
  {
    return a(paramString, "com.tencent.mobileqq.nearby.flat.canvas.", paramAttributeSet);
  }
  
  public final UIElement a(String paramString1, String paramString2, AttributeSet paramAttributeSet)
  {
    Object localObject1 = (Constructor)jdField_a_of_type_JavaUtilHashMap.get(paramString1);
    Object localObject2 = null;
    Object localObject3 = localObject1;
    if (localObject1 == null) {}
    for (;;)
    {
      try
      {
        localObject2 = this.jdField_a_of_type_AndroidContentContext.getClassLoader();
        if (paramString2 != null)
        {
          localObject1 = paramString2 + paramString1;
          localObject2 = ((ClassLoader)localObject2).loadClass((String)localObject1).asSubclass(UIElement.class);
          localObject1 = localObject2;
        }
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        Object[] arrayOfObject;
        localObject2 = new StringBuilder().append(paramAttributeSet.getPositionDescription()).append(": Error inflating class ");
        paramAttributeSet = paramString1;
        if (paramString2 != null) {
          paramAttributeSet = paramString2 + paramString1;
        }
        paramString1 = new InflateException(paramAttributeSet);
        paramString1.initCause(localNoSuchMethodException);
        throw paramString1;
      }
      catch (ClassCastException localClassCastException)
      {
        localObject2 = new StringBuilder().append(paramAttributeSet.getPositionDescription()).append(": Class is not a View ");
        paramAttributeSet = paramString1;
        if (paramString2 != null) {
          paramAttributeSet = paramString2 + paramString1;
        }
        paramString1 = new InflateException(paramAttributeSet);
        paramString1.initCause(localClassCastException);
        throw paramString1;
      }
      catch (ClassNotFoundException paramString1)
      {
        throw paramString1;
      }
      catch (Exception paramString1)
      {
        paramString2 = null;
      }
      try
      {
        localObject3 = ((Class)localObject2).getConstructor(jdField_a_of_type_ArrayOfJavaLangClass);
        localObject1 = localObject2;
        jdField_a_of_type_JavaUtilHashMap.put(paramString1, localObject3);
        localObject1 = localObject2;
        arrayOfObject = this.jdField_a_of_type_ArrayOfJavaLangObject;
        arrayOfObject[1] = paramAttributeSet;
        localObject1 = localObject2;
        localObject2 = (UIElement)((Constructor)localObject3).newInstance(arrayOfObject);
        return (UIElement)localObject2;
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          paramString2 = localClassCastException;
        }
      }
      localObject1 = paramString1;
    }
    paramAttributeSet = new StringBuilder().append(paramAttributeSet.getPositionDescription()).append(": Error inflating class ");
    if (paramString2 == null) {}
    for (paramString2 = "<unknown>";; paramString2 = paramString2.getName())
    {
      paramString2 = new InflateException(paramString2);
      paramString2.initCause(paramString1);
      throw paramString2;
    }
  }
  
  public UIElement a(XmlPullParser paramXmlPullParser, UIElementHost paramUIElementHost, UIElementGroup paramUIElementGroup)
  {
    if (paramUIElementGroup != null) {}
    for (boolean bool = true;; bool = false) {
      return a(paramXmlPullParser, paramUIElementHost, paramUIElementGroup, bool);
    }
  }
  
  /* Error */
  public UIElement a(XmlPullParser paramXmlPullParser, UIElementHost paramUIElementHost, UIElementGroup paramUIElementGroup, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload_0
    //   4: getfield 45	com/tencent/mobileqq/nearby/flat/canvas/UIElementInflater:jdField_a_of_type_ArrayOfJavaLangObject	[Ljava/lang/Object;
    //   7: astore 7
    //   9: aload 7
    //   11: monitorenter
    //   12: aload_1
    //   13: invokestatic 176	android/util/Xml:asAttributeSet	(Lorg/xmlpull/v1/XmlPullParser;)Landroid/util/AttributeSet;
    //   16: astore 8
    //   18: aload_0
    //   19: getfield 45	com/tencent/mobileqq/nearby/flat/canvas/UIElementInflater:jdField_a_of_type_ArrayOfJavaLangObject	[Ljava/lang/Object;
    //   22: iconst_0
    //   23: aload_2
    //   24: aastore
    //   25: aload_1
    //   26: invokeinterface 182 1 0
    //   31: istore 9
    //   33: iload 9
    //   35: iconst_2
    //   36: if_icmpeq +9 -> 45
    //   39: iload 9
    //   41: iconst_1
    //   42: if_icmpne -17 -> 25
    //   45: iload 9
    //   47: iconst_2
    //   48: if_icmpeq +79 -> 127
    //   51: new 151	android/view/InflateException
    //   54: dup
    //   55: new 111	java/lang/StringBuilder
    //   58: dup
    //   59: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   62: aload_1
    //   63: invokeinterface 183 1 0
    //   68: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: ldc -71
    //   73: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: invokespecial 154	android/view/InflateException:<init>	(Ljava/lang/String;)V
    //   82: athrow
    //   83: astore_1
    //   84: new 151	android/view/InflateException
    //   87: dup
    //   88: aload_1
    //   89: invokevirtual 188	org/xmlpull/v1/XmlPullParserException:getMessage	()Ljava/lang/String;
    //   92: invokespecial 154	android/view/InflateException:<init>	(Ljava/lang/String;)V
    //   95: astore_2
    //   96: aload_2
    //   97: aload_1
    //   98: invokevirtual 158	android/view/InflateException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   101: pop
    //   102: aload_2
    //   103: athrow
    //   104: astore_1
    //   105: aload_0
    //   106: getfield 45	com/tencent/mobileqq/nearby/flat/canvas/UIElementInflater:jdField_a_of_type_ArrayOfJavaLangObject	[Ljava/lang/Object;
    //   109: iconst_0
    //   110: aconst_null
    //   111: aastore
    //   112: aload_0
    //   113: getfield 45	com/tencent/mobileqq/nearby/flat/canvas/UIElementInflater:jdField_a_of_type_ArrayOfJavaLangObject	[Ljava/lang/Object;
    //   116: iconst_1
    //   117: aconst_null
    //   118: aastore
    //   119: aload_1
    //   120: athrow
    //   121: astore_1
    //   122: aload 7
    //   124: monitorexit
    //   125: aload_1
    //   126: athrow
    //   127: aload_1
    //   128: invokeinterface 189 1 0
    //   133: astore_2
    //   134: ldc 16
    //   136: aload_2
    //   137: invokevirtual 195	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   140: ifeq +98 -> 238
    //   143: aload_3
    //   144: ifnull +8 -> 152
    //   147: iload 4
    //   149: ifne +61 -> 210
    //   152: new 151	android/view/InflateException
    //   155: dup
    //   156: ldc -59
    //   158: invokespecial 154	android/view/InflateException:<init>	(Ljava/lang/String;)V
    //   161: athrow
    //   162: astore_2
    //   163: new 151	android/view/InflateException
    //   166: dup
    //   167: new 111	java/lang/StringBuilder
    //   170: dup
    //   171: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   174: aload_1
    //   175: invokeinterface 183 1 0
    //   180: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: ldc -57
    //   185: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: aload_2
    //   189: invokevirtual 200	java/io/IOException:getMessage	()Ljava/lang/String;
    //   192: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   198: invokespecial 154	android/view/InflateException:<init>	(Ljava/lang/String;)V
    //   201: astore_1
    //   202: aload_1
    //   203: aload_2
    //   204: invokevirtual 158	android/view/InflateException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   207: pop
    //   208: aload_1
    //   209: athrow
    //   210: aload_0
    //   211: aload_1
    //   212: aload_3
    //   213: aload 8
    //   215: iconst_0
    //   216: invokevirtual 203	com/tencent/mobileqq/nearby/flat/canvas/UIElementInflater:a	(Lorg/xmlpull/v1/XmlPullParser;Lcom/tencent/mobileqq/nearby/flat/canvas/UIElement;Landroid/util/AttributeSet;Z)V
    //   219: aload_0
    //   220: getfield 45	com/tencent/mobileqq/nearby/flat/canvas/UIElementInflater:jdField_a_of_type_ArrayOfJavaLangObject	[Ljava/lang/Object;
    //   223: iconst_0
    //   224: aconst_null
    //   225: aastore
    //   226: aload_0
    //   227: getfield 45	com/tencent/mobileqq/nearby/flat/canvas/UIElementInflater:jdField_a_of_type_ArrayOfJavaLangObject	[Ljava/lang/Object;
    //   230: iconst_1
    //   231: aconst_null
    //   232: aastore
    //   233: aload 7
    //   235: monitorexit
    //   236: aload_3
    //   237: areturn
    //   238: aload_0
    //   239: aload_3
    //   240: aload_2
    //   241: aload 8
    //   243: invokevirtual 205	com/tencent/mobileqq/nearby/flat/canvas/UIElementInflater:b	(Lcom/tencent/mobileqq/nearby/flat/canvas/UIElement;Ljava/lang/String;Landroid/util/AttributeSet;)Lcom/tencent/mobileqq/nearby/flat/canvas/UIElement;
    //   246: astore 5
    //   248: aload 6
    //   250: astore_2
    //   251: aload_3
    //   252: ifnull +31 -> 283
    //   255: aload_3
    //   256: aload 8
    //   258: invokevirtual 210	com/tencent/mobileqq/nearby/flat/canvas/UIElementGroup:a	(Landroid/util/AttributeSet;)Landroid/view/ViewGroup$LayoutParams;
    //   261: astore 6
    //   263: aload 6
    //   265: astore_2
    //   266: iload 4
    //   268: ifne +15 -> 283
    //   271: aload 5
    //   273: aload 6
    //   275: invokeinterface 213 2 0
    //   280: aload 6
    //   282: astore_2
    //   283: aload_0
    //   284: aload_1
    //   285: aload 5
    //   287: aload 8
    //   289: iconst_1
    //   290: invokevirtual 203	com/tencent/mobileqq/nearby/flat/canvas/UIElementInflater:a	(Lorg/xmlpull/v1/XmlPullParser;Lcom/tencent/mobileqq/nearby/flat/canvas/UIElement;Landroid/util/AttributeSet;Z)V
    //   293: aload_3
    //   294: ifnull +15 -> 309
    //   297: iload 4
    //   299: ifeq +10 -> 309
    //   302: aload_3
    //   303: aload 5
    //   305: aload_2
    //   306: invokevirtual 216	com/tencent/mobileqq/nearby/flat/canvas/UIElementGroup:a	(Lcom/tencent/mobileqq/nearby/flat/canvas/UIElement;Landroid/view/ViewGroup$LayoutParams;)V
    //   309: aload_3
    //   310: ifnull +8 -> 318
    //   313: iload 4
    //   315: ifne -96 -> 219
    //   318: aload 5
    //   320: astore_3
    //   321: goto -102 -> 219
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	324	0	this	UIElementInflater
    //   0	324	1	paramXmlPullParser	XmlPullParser
    //   0	324	2	paramUIElementHost	UIElementHost
    //   0	324	3	paramUIElementGroup	UIElementGroup
    //   0	324	4	paramBoolean	boolean
    //   246	73	5	localUIElement	UIElement
    //   1	280	6	localLayoutParams	ViewGroup.LayoutParams
    //   7	227	7	arrayOfObject	Object[]
    //   16	272	8	localAttributeSet	AttributeSet
    //   31	18	9	i	int
    // Exception table:
    //   from	to	target	type
    //   25	33	83	org/xmlpull/v1/XmlPullParserException
    //   51	83	83	org/xmlpull/v1/XmlPullParserException
    //   127	143	83	org/xmlpull/v1/XmlPullParserException
    //   152	162	83	org/xmlpull/v1/XmlPullParserException
    //   210	219	83	org/xmlpull/v1/XmlPullParserException
    //   238	248	83	org/xmlpull/v1/XmlPullParserException
    //   255	263	83	org/xmlpull/v1/XmlPullParserException
    //   271	280	83	org/xmlpull/v1/XmlPullParserException
    //   283	293	83	org/xmlpull/v1/XmlPullParserException
    //   302	309	83	org/xmlpull/v1/XmlPullParserException
    //   25	33	104	finally
    //   51	83	104	finally
    //   84	104	104	finally
    //   127	143	104	finally
    //   152	162	104	finally
    //   163	210	104	finally
    //   210	219	104	finally
    //   238	248	104	finally
    //   255	263	104	finally
    //   271	280	104	finally
    //   283	293	104	finally
    //   302	309	104	finally
    //   12	25	121	finally
    //   105	121	121	finally
    //   122	125	121	finally
    //   219	236	121	finally
    //   25	33	162	java/io/IOException
    //   51	83	162	java/io/IOException
    //   127	143	162	java/io/IOException
    //   152	162	162	java/io/IOException
    //   210	219	162	java/io/IOException
    //   238	248	162	java/io/IOException
    //   255	263	162	java/io/IOException
    //   271	280	162	java/io/IOException
    //   283	293	162	java/io/IOException
    //   302	309	162	java/io/IOException
  }
  
  void a(XmlPullParser paramXmlPullParser, UIElement paramUIElement, AttributeSet paramAttributeSet, boolean paramBoolean)
  {
    int i = paramXmlPullParser.getDepth();
    for (;;)
    {
      int j = paramXmlPullParser.next();
      if (((j == 3) && (paramXmlPullParser.getDepth() <= i)) || (j == 1)) {
        break;
      }
      if (j == 2)
      {
        Object localObject = paramXmlPullParser.getName();
        if ("merge".equals(localObject)) {
          throw new InflateException("<merge /> must be the root element");
        }
        localObject = b(paramUIElement, (String)localObject, paramAttributeSet);
        UIElementGroup localUIElementGroup = (UIElementGroup)paramUIElement;
        ViewGroup.LayoutParams localLayoutParams = localUIElementGroup.a(paramAttributeSet);
        a(paramXmlPullParser, (UIElement)localObject, paramAttributeSet, true);
        localUIElementGroup.a((UIElement)localObject, localLayoutParams);
      }
    }
    if (paramBoolean) {
      paramUIElement.d();
    }
  }
  
  UIElement b(UIElement paramUIElement, String paramString, AttributeSet paramAttributeSet)
  {
    String str = paramString;
    if (paramString.equals("element")) {
      str = paramAttributeSet.getAttributeValue(null, "class");
    }
    try
    {
      if (-1 == str.indexOf('.')) {
        return a(paramUIElement, str, paramAttributeSet);
      }
      paramUIElement = a(str, null, paramAttributeSet);
      return paramUIElement;
    }
    catch (InflateException paramUIElement)
    {
      throw paramUIElement;
    }
    catch (ClassNotFoundException paramUIElement)
    {
      paramString = new InflateException(paramAttributeSet.getPositionDescription() + ": Error inflating class " + str);
      paramString.initCause(paramUIElement);
      throw paramString;
    }
    catch (Exception paramUIElement)
    {
      paramString = new InflateException(paramAttributeSet.getPositionDescription() + ": Error inflating class " + str);
      paramString.initCause(paramUIElement);
      throw paramString;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\nearby\flat\canvas\UIElementInflater.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */