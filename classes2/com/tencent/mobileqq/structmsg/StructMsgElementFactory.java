package com.tencent.mobileqq.structmsg;

import android.util.SparseArray;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.structmsg.view.StructMsgItemAsyncMsg;
import com.tencent.mobileqq.structmsg.view.StructMsgItemButton;
import com.tencent.mobileqq.structmsg.view.StructMsgItemContent;
import com.tencent.mobileqq.structmsg.view.StructMsgItemCover;
import com.tencent.mobileqq.structmsg.view.StructMsgItemHr;
import com.tencent.mobileqq.structmsg.view.StructMsgItemImage;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout1;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout10;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout11;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout12;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout13;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout14;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout15;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout18;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout2;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout3;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout4;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout5;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout6;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout7;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout8;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout9;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayoutDefault;
import com.tencent.mobileqq.structmsg.view.StructMsgItemMore;
import com.tencent.mobileqq.structmsg.view.StructMsgItemPAAudio;
import com.tencent.mobileqq.structmsg.view.StructMsgItemPAVideo;
import com.tencent.mobileqq.structmsg.view.StructMsgItemPrice;
import com.tencent.mobileqq.structmsg.view.StructMsgItemProgress;
import com.tencent.mobileqq.structmsg.view.StructMsgItemRemark;
import com.tencent.mobileqq.structmsg.view.StructMsgItemSummary;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTextButton;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTimer;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.structmsg.view.StructMsgItemVideo;
import com.tencent.mobileqq.structmsg.view.StructMsgItemVote;
import com.tencent.mobileqq.structmsg.view.StructMsgItemVoteCover;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.HashMap;

public class StructMsgElementFactory
{
  private static final SparseArray jdField_a_of_type_AndroidUtilSparseArray;
  private static final String jdField_a_of_type_JavaLangString;
  private static HashMap jdField_a_of_type_JavaUtilHashMap;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = StructMsgElementFactory.class.getSimpleName();
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_JavaUtilHashMap.put("pavideo", StructMsgItemPAVideo.class);
    jdField_a_of_type_JavaUtilHashMap.put("video", StructMsgItemVideo.class);
    jdField_a_of_type_JavaUtilHashMap.put("picture", StructMsgItemCover.class);
    jdField_a_of_type_JavaUtilHashMap.put("title", StructMsgItemTitle.class);
    jdField_a_of_type_JavaUtilHashMap.put("summary", StructMsgItemSummary.class);
    jdField_a_of_type_JavaUtilHashMap.put("timer", StructMsgItemTimer.class);
    jdField_a_of_type_JavaUtilHashMap.put("hr", StructMsgItemHr.class);
    jdField_a_of_type_JavaUtilHashMap.put("image", StructMsgItemImage.class);
    jdField_a_of_type_JavaUtilHashMap.put("more", StructMsgItemMore.class);
    jdField_a_of_type_JavaUtilHashMap.put("progress", StructMsgItemProgress.class);
    jdField_a_of_type_JavaUtilHashMap.put("checklist", StructMsgItemVote.class);
    jdField_a_of_type_JavaUtilHashMap.put("vote", StructMsgItemVoteCover.class);
    jdField_a_of_type_JavaUtilHashMap.put("price", StructMsgItemPrice.class);
    jdField_a_of_type_JavaUtilHashMap.put("button", StructMsgItemButton.class);
    jdField_a_of_type_JavaUtilHashMap.put("remark", StructMsgItemRemark.class);
    jdField_a_of_type_JavaUtilHashMap.put("paaudio", StructMsgItemPAAudio.class);
    jdField_a_of_type_JavaUtilHashMap.put("asyncmsg", StructMsgItemAsyncMsg.class);
    jdField_a_of_type_JavaUtilHashMap.put("textButton", StructMsgItemTextButton.class);
    jdField_a_of_type_JavaUtilHashMap.put("content", StructMsgItemContent.class);
    jdField_a_of_type_JavaUtilHashMap.put("tips", StructMsgItemTips.class);
    jdField_a_of_type_JavaUtilHashMap.put("live", StructMsgItemLive.class);
    jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    jdField_a_of_type_AndroidUtilSparseArray.append(0, StructMsgItemLayoutDefault.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(1, StructMsgItemLayout1.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(2, StructMsgItemLayout2.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(3, StructMsgItemLayout3.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(4, StructMsgItemLayout4.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(5, StructMsgItemLayout5.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(6, StructMsgItemLayout6.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(7, StructMsgItemLayout7.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(8, StructMsgItemLayout8.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(9, StructMsgItemLayout9.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(10, StructMsgItemLayout10.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(11, StructMsgItemLayout11.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(12, StructMsgItemLayout12.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(13, StructMsgItemLayout13.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(14, StructMsgItemLayout14.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(15, StructMsgItemLayout15.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(18, StructMsgItemLayout18.class);
  }
  
  public static AbsStructMsgElement a(String paramString)
  {
    return a(paramString, 0);
  }
  
  /* Error */
  public static AbsStructMsgElement a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: ldc -82
    //   2: aload_0
    //   3: invokevirtual 180	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6: ifne +73 -> 79
    //   9: getstatic 31	com/tencent/mobileqq/structmsg/StructMsgElementFactory:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   12: aload_0
    //   13: invokevirtual 184	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   16: checkcast 18	java/lang/Class
    //   19: astore_2
    //   20: aload_2
    //   21: ifnull +421 -> 442
    //   24: aload_2
    //   25: invokevirtual 188	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   28: checkcast 190	com/tencent/mobileqq/structmsg/AbsStructMsgElement
    //   31: astore_3
    //   32: aload_2
    //   33: ifnonnull +60 -> 93
    //   36: invokestatic 196	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   39: ifeq +38 -> 77
    //   42: getstatic 24	com/tencent/mobileqq/structmsg/StructMsgElementFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   45: iconst_2
    //   46: new 198	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 199	java/lang/StringBuilder:<init>	()V
    //   53: ldc -55
    //   55: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: aload_0
    //   59: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: ldc -50
    //   64: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: iload_1
    //   68: invokevirtual 209	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   71: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: invokestatic 216	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   77: aload_3
    //   78: areturn
    //   79: getstatic 124	com/tencent/mobileqq/structmsg/StructMsgElementFactory:jdField_a_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   82: iload_1
    //   83: invokevirtual 219	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   86: checkcast 18	java/lang/Class
    //   89: astore_2
    //   90: goto -70 -> 20
    //   93: aload_3
    //   94: ifnonnull -17 -> 77
    //   97: invokestatic 196	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   100: ifeq -23 -> 77
    //   103: getstatic 24	com/tencent/mobileqq/structmsg/StructMsgElementFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   106: iconst_2
    //   107: new 198	java/lang/StringBuilder
    //   110: dup
    //   111: invokespecial 199	java/lang/StringBuilder:<init>	()V
    //   114: ldc -35
    //   116: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: aload_2
    //   120: invokevirtual 22	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   123: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: ldc -33
    //   128: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   134: invokestatic 216	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   137: aload_3
    //   138: areturn
    //   139: astore_2
    //   140: aconst_null
    //   141: astore_2
    //   142: aload_2
    //   143: ifnonnull +46 -> 189
    //   146: invokestatic 196	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   149: ifeq +291 -> 440
    //   152: getstatic 24	com/tencent/mobileqq/structmsg/StructMsgElementFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   155: iconst_2
    //   156: new 198	java/lang/StringBuilder
    //   159: dup
    //   160: invokespecial 199	java/lang/StringBuilder:<init>	()V
    //   163: ldc -55
    //   165: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: aload_0
    //   169: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: ldc -50
    //   174: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: iload_1
    //   178: invokevirtual 209	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   181: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: invokestatic 216	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   187: aconst_null
    //   188: areturn
    //   189: iconst_0
    //   190: ifne +250 -> 440
    //   193: invokestatic 196	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   196: ifeq +244 -> 440
    //   199: getstatic 24	com/tencent/mobileqq/structmsg/StructMsgElementFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   202: iconst_2
    //   203: new 198	java/lang/StringBuilder
    //   206: dup
    //   207: invokespecial 199	java/lang/StringBuilder:<init>	()V
    //   210: ldc -35
    //   212: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: aload_2
    //   216: invokevirtual 22	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   219: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: ldc -33
    //   224: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   230: invokestatic 216	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   233: aconst_null
    //   234: areturn
    //   235: astore_2
    //   236: aconst_null
    //   237: astore_2
    //   238: aload_2
    //   239: ifnonnull +46 -> 285
    //   242: invokestatic 196	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   245: ifeq +195 -> 440
    //   248: getstatic 24	com/tencent/mobileqq/structmsg/StructMsgElementFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   251: iconst_2
    //   252: new 198	java/lang/StringBuilder
    //   255: dup
    //   256: invokespecial 199	java/lang/StringBuilder:<init>	()V
    //   259: ldc -55
    //   261: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: aload_0
    //   265: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: ldc -50
    //   270: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: iload_1
    //   274: invokevirtual 209	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   277: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   280: invokestatic 216	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   283: aconst_null
    //   284: areturn
    //   285: iconst_0
    //   286: ifne +154 -> 440
    //   289: invokestatic 196	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   292: ifeq +148 -> 440
    //   295: getstatic 24	com/tencent/mobileqq/structmsg/StructMsgElementFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   298: iconst_2
    //   299: new 198	java/lang/StringBuilder
    //   302: dup
    //   303: invokespecial 199	java/lang/StringBuilder:<init>	()V
    //   306: ldc -35
    //   308: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: aload_2
    //   312: invokevirtual 22	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   315: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: ldc -33
    //   320: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   326: invokestatic 216	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   329: aconst_null
    //   330: areturn
    //   331: astore_3
    //   332: aconst_null
    //   333: astore_2
    //   334: aload_2
    //   335: ifnonnull +46 -> 381
    //   338: invokestatic 196	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   341: ifeq +38 -> 379
    //   344: getstatic 24	com/tencent/mobileqq/structmsg/StructMsgElementFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   347: iconst_2
    //   348: new 198	java/lang/StringBuilder
    //   351: dup
    //   352: invokespecial 199	java/lang/StringBuilder:<init>	()V
    //   355: ldc -55
    //   357: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: aload_0
    //   361: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   364: ldc -50
    //   366: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   369: iload_1
    //   370: invokevirtual 209	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   373: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   376: invokestatic 216	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   379: aload_3
    //   380: athrow
    //   381: iconst_0
    //   382: ifne -3 -> 379
    //   385: invokestatic 196	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   388: ifeq -9 -> 379
    //   391: getstatic 24	com/tencent/mobileqq/structmsg/StructMsgElementFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   394: iconst_2
    //   395: new 198	java/lang/StringBuilder
    //   398: dup
    //   399: invokespecial 199	java/lang/StringBuilder:<init>	()V
    //   402: ldc -35
    //   404: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: aload_2
    //   408: invokevirtual 22	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   411: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   414: ldc -33
    //   416: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   422: invokestatic 216	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   425: goto -46 -> 379
    //   428: astore_3
    //   429: goto -95 -> 334
    //   432: astore_3
    //   433: goto -195 -> 238
    //   436: astore_3
    //   437: goto -295 -> 142
    //   440: aconst_null
    //   441: areturn
    //   442: aconst_null
    //   443: astore_3
    //   444: goto -412 -> 32
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	447	0	paramString	String
    //   0	447	1	paramInt	int
    //   19	101	2	localClass	Class
    //   139	1	2	localIllegalAccessException1	IllegalAccessException
    //   141	75	2	localObject1	Object
    //   235	1	2	localInstantiationException1	InstantiationException
    //   237	171	2	localObject2	Object
    //   31	107	3	localAbsStructMsgElement	AbsStructMsgElement
    //   331	49	3	localObject3	Object
    //   428	1	3	localObject4	Object
    //   432	1	3	localInstantiationException2	InstantiationException
    //   436	1	3	localIllegalAccessException2	IllegalAccessException
    //   443	1	3	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   0	20	139	java/lang/IllegalAccessException
    //   79	90	139	java/lang/IllegalAccessException
    //   0	20	235	java/lang/InstantiationException
    //   79	90	235	java/lang/InstantiationException
    //   0	20	331	finally
    //   79	90	331	finally
    //   24	32	428	finally
    //   24	32	432	java/lang/InstantiationException
    //   24	32	436	java/lang/IllegalAccessException
  }
  
  public static AbsStructMsgItem a(int paramInt)
  {
    Class localClass = (Class)jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localClass != null) {}
    for (;;)
    {
      try
      {
        AbsStructMsgItem localAbsStructMsgItem1 = (AbsStructMsgItem)localClass.newInstance();
        if (localClass == null)
        {
          if (!QLog.isColorLevel()) {
            break label365;
          }
          QLog.e(jdField_a_of_type_JavaLangString, 2, "Not supported element, layout = " + paramInt);
          return localAbsStructMsgItem1;
        }
        if ((localAbsStructMsgItem1 != null) || (!QLog.isColorLevel())) {
          break label365;
        }
        QLog.e(jdField_a_of_type_JavaLangString, 2, "New instance " + localClass.getSimpleName() + " failure.");
        return localAbsStructMsgItem1;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        localIllegalAccessException = localIllegalAccessException;
        if (localClass == null)
        {
          if (QLog.isColorLevel())
          {
            QLog.e(jdField_a_of_type_JavaLangString, 2, "Not supported element, layout = " + paramInt);
            return null;
          }
        }
        else if ((0 == 0) && (QLog.isColorLevel()))
        {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "New instance " + localClass.getSimpleName() + " failure.");
          return null;
        }
      }
      catch (InstantiationException localInstantiationException)
      {
        localInstantiationException = localInstantiationException;
        if (localClass == null)
        {
          if (QLog.isColorLevel())
          {
            QLog.e(jdField_a_of_type_JavaLangString, 2, "Not supported element, layout = " + paramInt);
            return null;
          }
        }
        else if ((0 == 0) && (QLog.isColorLevel()))
        {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "New instance " + localClass.getSimpleName() + " failure.");
          return null;
        }
      }
      finally
      {
        localAbsStructMsgItem2 = finally;
        if (localClass == null)
        {
          if (QLog.isColorLevel()) {
            QLog.e(jdField_a_of_type_JavaLangString, 2, "Not supported element, layout = " + paramInt);
          }
          throw localAbsStructMsgItem2;
        }
        if ((0 != 0) || (!QLog.isColorLevel())) {
          continue;
        }
        QLog.e(jdField_a_of_type_JavaLangString, 2, "New instance " + localClass.getSimpleName() + " failure.");
        continue;
      }
      return null;
      label365:
      return localAbsStructMsgItem2;
      Object localObject = null;
    }
  }
  
  public static AbsStructMsgItem a(int paramInt1, int paramInt2)
  {
    Class localClass = (Class)jdField_a_of_type_AndroidUtilSparseArray.get(paramInt1);
    if (localClass != null) {}
    for (;;)
    {
      try
      {
        Object localObject1 = localClass.getDeclaredConstructor(new Class[] { Integer.TYPE });
        ((Constructor)localObject1).setAccessible(true);
        localObject1 = (AbsStructMsgItem)((Constructor)localObject1).newInstance(new Object[] { Integer.valueOf(paramInt2) });
        if (localClass == null)
        {
          if (!QLog.isColorLevel()) {
            break label566;
          }
          QLog.e(jdField_a_of_type_JavaLangString, 2, "Not supported element, layout = " + paramInt1);
          return (AbsStructMsgItem)localObject1;
        }
        if ((localObject1 != null) || (!QLog.isColorLevel())) {
          break label566;
        }
        QLog.e(jdField_a_of_type_JavaLangString, 2, "New instance " + localClass.getSimpleName() + " failure.");
        return (AbsStructMsgItem)localObject1;
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        localNoSuchMethodException = localNoSuchMethodException;
        if (localClass == null)
        {
          if (QLog.isColorLevel())
          {
            QLog.e(jdField_a_of_type_JavaLangString, 2, "Not supported element, layout = " + paramInt1);
            return null;
          }
        }
        else if ((0 == 0) && (QLog.isColorLevel()))
        {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "New instance " + localClass.getSimpleName() + " failure.");
          return null;
        }
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        localInvocationTargetException = localInvocationTargetException;
        if (localClass == null)
        {
          if (QLog.isColorLevel())
          {
            QLog.e(jdField_a_of_type_JavaLangString, 2, "Not supported element, layout = " + paramInt1);
            return null;
          }
        }
        else if ((0 == 0) && (QLog.isColorLevel()))
        {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "New instance " + localClass.getSimpleName() + " failure.");
          return null;
        }
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        localIllegalAccessException = localIllegalAccessException;
        if (localClass == null)
        {
          if (QLog.isColorLevel())
          {
            QLog.e(jdField_a_of_type_JavaLangString, 2, "Not supported element, layout = " + paramInt1);
            return null;
          }
        }
        else if ((0 == 0) && (QLog.isColorLevel()))
        {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "New instance " + localClass.getSimpleName() + " failure.");
          return null;
        }
      }
      catch (InstantiationException localInstantiationException)
      {
        localInstantiationException = localInstantiationException;
        if (localClass == null)
        {
          if (QLog.isColorLevel())
          {
            QLog.e(jdField_a_of_type_JavaLangString, 2, "Not supported element, layout = " + paramInt1);
            return null;
          }
        }
        else if ((0 == 0) && (QLog.isColorLevel()))
        {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "New instance " + localClass.getSimpleName() + " failure.");
          return null;
        }
      }
      finally
      {
        localAbsStructMsgItem = finally;
        if (localClass == null)
        {
          if (QLog.isColorLevel()) {
            QLog.e(jdField_a_of_type_JavaLangString, 2, "Not supported element, layout = " + paramInt1);
          }
          throw localAbsStructMsgItem;
        }
        if ((0 != 0) || (!QLog.isColorLevel())) {
          continue;
        }
        QLog.e(jdField_a_of_type_JavaLangString, 2, "New instance " + localClass.getSimpleName() + " failure.");
        continue;
      }
      return null;
      label566:
      return localAbsStructMsgItem;
      Object localObject2 = null;
    }
  }
  
  public static AbsStructMsgItem a(int paramInt, Collection paramCollection)
  {
    Class localClass = (Class)jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localClass != null) {}
    for (;;)
    {
      try
      {
        Constructor localConstructor = localClass.getDeclaredConstructor(new Class[] { Collection.class });
        localConstructor.setAccessible(true);
        paramCollection = (AbsStructMsgItem)localConstructor.newInstance(new Object[] { paramCollection });
        if (localClass == null)
        {
          if (!QLog.isColorLevel()) {
            break label563;
          }
          QLog.e(jdField_a_of_type_JavaLangString, 2, "Not supported element, layout = " + paramInt);
          return paramCollection;
        }
        if ((paramCollection != null) || (!QLog.isColorLevel())) {
          break label563;
        }
        QLog.e(jdField_a_of_type_JavaLangString, 2, "New instance " + localClass.getSimpleName() + " failure.");
        return paramCollection;
      }
      catch (NoSuchMethodException paramCollection)
      {
        paramCollection = paramCollection;
        if (localClass == null)
        {
          if (QLog.isColorLevel())
          {
            QLog.e(jdField_a_of_type_JavaLangString, 2, "Not supported element, layout = " + paramInt);
            return null;
          }
        }
        else if ((0 == 0) && (QLog.isColorLevel()))
        {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "New instance " + localClass.getSimpleName() + " failure.");
          return null;
        }
      }
      catch (InvocationTargetException paramCollection)
      {
        paramCollection = paramCollection;
        if (localClass == null)
        {
          if (QLog.isColorLevel())
          {
            QLog.e(jdField_a_of_type_JavaLangString, 2, "Not supported element, layout = " + paramInt);
            return null;
          }
        }
        else if ((0 == 0) && (QLog.isColorLevel()))
        {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "New instance " + localClass.getSimpleName() + " failure.");
          return null;
        }
      }
      catch (IllegalAccessException paramCollection)
      {
        paramCollection = paramCollection;
        if (localClass == null)
        {
          if (QLog.isColorLevel())
          {
            QLog.e(jdField_a_of_type_JavaLangString, 2, "Not supported element, layout = " + paramInt);
            return null;
          }
        }
        else if ((0 == 0) && (QLog.isColorLevel()))
        {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "New instance " + localClass.getSimpleName() + " failure.");
          return null;
        }
      }
      catch (InstantiationException paramCollection)
      {
        paramCollection = paramCollection;
        if (localClass == null)
        {
          if (QLog.isColorLevel())
          {
            QLog.e(jdField_a_of_type_JavaLangString, 2, "Not supported element, layout = " + paramInt);
            return null;
          }
        }
        else if ((0 == 0) && (QLog.isColorLevel()))
        {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "New instance " + localClass.getSimpleName() + " failure.");
          return null;
        }
      }
      finally
      {
        paramCollection = finally;
        if (localClass == null)
        {
          if (QLog.isColorLevel()) {
            QLog.e(jdField_a_of_type_JavaLangString, 2, "Not supported element, layout = " + paramInt);
          }
          throw paramCollection;
        }
        if ((0 != 0) || (!QLog.isColorLevel())) {
          continue;
        }
        QLog.e(jdField_a_of_type_JavaLangString, 2, "New instance " + localClass.getSimpleName() + " failure.");
        continue;
      }
      return null;
      label563:
      return paramCollection;
      paramCollection = null;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\structmsg\StructMsgElementFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */