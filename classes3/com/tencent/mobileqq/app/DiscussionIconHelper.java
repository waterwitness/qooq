package com.tencent.mobileqq.app;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import com.tencent.av.utils.PstnUtils;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.PhoneContactManager.IPhoneContactListener;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.os.MqqHandler;
import pxb;
import pxc;
import pxd;
import pxe;
import pxf;
import pxg;

public class DiscussionIconHelper
  extends FriendListObserver
  implements Handler.Callback, PhoneContactManager.IPhoneContactListener
{
  private static final byte jdField_a_of_type_Byte = 1;
  public static final int a = 5;
  static final String jdField_a_of_type_JavaLangString = "Q.qqhead.dih";
  private static final boolean jdField_a_of_type_Boolean = false;
  private static final byte jdField_b_of_type_Byte = 2;
  public static final int b = 4;
  private static final byte jdField_c_of_type_Byte = 3;
  private static int e = 72;
  private static final int f = 9527;
  private static final int g = 300;
  private static final int h = 8;
  private static final int i = 3600000;
  private DiscussionHandler jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private Comparator jdField_a_of_type_JavaUtilComparator = new pxb(this);
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  private Hashtable jdField_a_of_type_JavaUtilHashtable;
  private Set jdField_a_of_type_JavaUtilSet;
  private pxc jdField_a_of_type_Pxc;
  private pxg jdField_a_of_type_Pxg;
  private Set jdField_b_of_type_JavaUtilSet;
  private boolean jdField_b_of_type_Boolean;
  private String jdField_c_of_type_JavaLangString;
  private int j = 60000;
  private int k = 90000;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public DiscussionIconHelper(String paramString, DiscussionHandler paramDiscussionHandler)
  {
    this.c = paramString;
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.dih", 2, "Create DiscussionIconHelper For [" + this.c + "]");
    }
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilHashtable = new Hashtable();
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_b_of_type_JavaUtilSet = new HashSet();
    this.jdField_a_of_type_Pxg = new pxg(paramDiscussionHandler.b.a().getMainLooper(), this, null);
    this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler = paramDiscussionHandler;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler.b;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new pxd(this));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this);
    paramString = (PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
    if (paramString != null) {
      paramString.a(this);
    }
  }
  
  private Pair a(String paramString1, String paramString2, ArrayList paramArrayList, boolean paramBoolean1, boolean paramBoolean2)
  {
    int m = 0;
    if ((paramString1 == null) || (paramString1.length() <= 1))
    {
      m = 1;
      if (!paramBoolean2) {
        return Pair.create(Boolean.valueOf(false), null);
      }
    }
    boolean bool = true;
    float f2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getResources().getDisplayMetrics().density;
    float f1 = f2;
    if (f2 < 1.0F) {
      f1 = 1.0F;
    }
    int i1 = (int)(50.0F * f1 + 0.5D);
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.dih", 2, "createDiscussionIcon density=" + f1 + ";imageWidth=" + i1 + ",hasPstnIcon: " + paramBoolean1 + ", hasRealPhoneUser: " + paramBoolean2);
    }
    if (m == 0) {}
    for (String[] arrayOfString = paramString1.split(";");; arrayOfString = null)
    {
      m = 0;
      int n;
      if (arrayOfString != null)
      {
        if (arrayOfString.length > 5) {
          m = 5;
        }
      }
      else
      {
        if ((m >= 5) || (!paramBoolean1)) {
          break label530;
        }
        paramString1 = PstnUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2, 3000, 5 - m);
        if ((paramString1 == null) || (paramString1.size() <= 0)) {
          break label523;
        }
        n = paramString1.size();
      }
      for (;;)
      {
        synchronized (this.jdField_a_of_type_JavaUtilSet)
        {
          this.jdField_a_of_type_JavaUtilSet.add(paramString2);
          n += m;
          ??? = new Bitmap[n];
          n = 0;
          paramBoolean1 = bool;
          if (n < m)
          {
            String str = arrayOfString[n];
            Pair localPair = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(str, 0, 0);
            if (!((Boolean)localPair.first).booleanValue())
            {
              if (QLog.isColorLevel()) {
                QLog.d("Q.qqhead.dih", 2, "getScaledFaceBitmap fail, disUin=" + paramString2 + ", uin=" + str);
              }
              paramArrayList.remove(str);
              paramBoolean1 = false;
            }
            ???[n] = ((Bitmap)localPair.second);
            n += 1;
            continue;
            m = arrayOfString.length;
          }
        }
        if ((paramString1 != null) && (paramString1.size() > 0))
        {
          n = 0;
          while (n < paramString1.size())
          {
            ???[(n + m)] = ((Bitmap)paramString1.get(n));
            n += 1;
          }
        }
        try
        {
          paramString1 = a(i1, (Bitmap[])???);
          return Pair.create(Boolean.valueOf(paramBoolean1), paramString1);
        }
        catch (Throwable paramString1)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.qqhead.dih", 2, "createDiscussionIcon fail, disUin=" + paramString2 + ", throwable : " + paramString1.toString());
            }
            paramBoolean1 = false;
            paramString1 = null;
          }
        }
        label523:
        n = m;
        continue;
        label530:
        paramString1 = null;
        n = m;
      }
    }
  }
  
  public static String a(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0))
    {
      QLog.i("Q.qqhead.dih", 1, "===getPstnDiscussionUin discussionUin is null ===");
      return null;
    }
    return paramString + "_" + 1001;
  }
  
  private String a(ArrayList paramArrayList, String paramString, boolean paramBoolean)
  {
    int n = 0;
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      paramString = new StringBuilder(128);
      paramArrayList = (ArrayList)paramArrayList.clone();
      String[] arrayOfString = new String[paramArrayList.size()];
      int m = 0;
      while (m < arrayOfString.length)
      {
        arrayOfString[m] = ((String)paramArrayList.get(m));
        m += 1;
      }
      Arrays.sort(arrayOfString, this.jdField_a_of_type_JavaUtilComparator);
      int i1 = 0;
      m = n;
      n = i1;
      for (;;)
      {
        if (m < arrayOfString.length)
        {
          paramString.append(arrayOfString[m]).append(";");
          n += 1;
          if ((!paramBoolean) || (!a()) || (n < 4)) {
            break label147;
          }
        }
        label147:
        while (n >= 5) {
          return paramString.toString();
        }
        m += 1;
      }
    }
    return " ";
  }
  
  private pxe a(String paramString, boolean paramBoolean1, pxe parampxe, boolean paramBoolean2)
  {
    Object localObject1 = (DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
    Object localObject2 = ((DiscussionManager)localObject1).b(paramString);
    label91:
    Object localObject3;
    Object localObject4;
    if (QLog.isColorLevel())
    {
      if ((localObject2 == null) || (((ArrayList)localObject2).size() == 0)) {
        QLog.d("Q.qqhead.dih", 2, "discussionUin=" + paramString + " memberUinList is empty...");
      }
    }
    else
    {
      if ((localObject2 != null) && (((ArrayList)localObject2).size() != 0)) {
        break label456;
      }
      parampxe.jdField_a_of_type_Int = 0;
      localObject3 = a((ArrayList)localObject2, paramString, paramBoolean2);
      parampxe.jdField_a_of_type_JavaLangString = ((String)localObject3);
      if (paramBoolean1)
      {
        localObject1 = ((DiscussionManager)localObject1).a(paramString);
        if (localObject1 != null)
        {
          localObject4 = ((DiscussionInfo)localObject1).faceUinSet;
          if (((localObject4 != null) && (!"".equals(((String)localObject4).trim()))) || ((localObject3 != null) && (!"".equals(((String)localObject3).trim())))) {
            break label468;
          }
          paramBoolean1 = false;
        }
      }
    }
    for (;;)
    {
      parampxe.jdField_a_of_type_Boolean = paramBoolean1;
      if (QLog.isColorLevel())
      {
        localObject2 = ((DiscussionInfo)localObject1).discussionName;
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (((String)localObject2).length() > 3) {
            localObject1 = ((String)localObject2).substring(0, 2) + "." + ((String)localObject2).charAt(((String)localObject2).length() - 1);
          }
        }
        QLog.d("Q.qqhead.dih", 2, "getDiscussionIconInfo. disUin=" + paramString + ", isChanged=" + paramBoolean1 + ", name=" + (String)localObject1 + ", faceUinSet=" + (String)localObject4 + ", newFaceUinSet=" + (String)localObject3);
      }
      return parampxe;
      localObject3 = new StringBuilder();
      localObject4 = ((ArrayList)localObject2).iterator();
      if (((Iterator)localObject4).hasNext())
      {
        String str = (String)((Iterator)localObject4).next();
        if ((str != null) && (str.length() > 5)) {
          ((StringBuilder)localObject3).append(str.substring(0, 4));
        }
        for (;;)
        {
          ((StringBuilder)localObject3).append(";");
          break;
          ((StringBuilder)localObject3).append(str);
        }
      }
      QLog.d("Q.qqhead.dih", 2, "discussionUin=" + paramString + " memberUinList is:" + ((StringBuilder)localObject3).toString());
      break;
      label456:
      parampxe.jdField_a_of_type_Int = ((ArrayList)localObject2).size();
      break label91;
      label468:
      if ((localObject3 != null) && (!((String)localObject3).equals(localObject4))) {
        paramBoolean1 = true;
      } else if ((localObject4 != null) && (!((String)localObject4).equals(localObject3))) {
        paramBoolean1 = true;
      } else if ((parampxe.jdField_a_of_type_Byte == 2) && (localObject3 != null) && (!((String)localObject3).equals(parampxe.jdField_b_of_type_JavaLangString))) {
        paramBoolean1 = true;
      } else {
        paramBoolean1 = false;
      }
    }
  }
  
  private void a(String paramString, pxe parampxe, boolean paramBoolean)
  {
    if (parampxe.jdField_a_of_type_Byte == 3)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqhead.dih", 2, "CreateIcon created: " + paramString + ", iconCount=" + parampxe.jdField_a_of_type_JavaUtilArrayList.size() + ", totalCount=" + parampxe.jdField_a_of_type_Int);
      }
      return;
    }
    Object localObject1 = b(parampxe.jdField_a_of_type_JavaLangString, paramString, parampxe.jdField_a_of_type_JavaUtilArrayList, parampxe.c, parampxe.d);
    boolean bool1 = ((Boolean)((Pair)localObject1).first).booleanValue();
    boolean bool2 = ((Boolean)((Pair)localObject1).second).booleanValue();
    String str;
    if (bool1)
    {
      parampxe.jdField_b_of_type_Int += 1;
      str = a(parampxe.jdField_a_of_type_JavaUtilArrayList, paramString, paramBoolean);
      parampxe.jdField_b_of_type_JavaLangString = str;
      localObject1 = (DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
      if (localObject1 == null) {
        break label568;
      }
    }
    label262:
    label498:
    label562:
    label568:
    for (localObject1 = ((DiscussionManager)localObject1).a(paramString);; localObject1 = null)
    {
      Object localObject2;
      if (localObject1 != null)
      {
        ((DiscussionInfo)localObject1).faceUinSet = str;
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
        ((EntityManager)localObject2).a((Entity)localObject1);
        ((EntityManager)localObject2).a();
      }
      if ((parampxe.jdField_a_of_type_JavaUtilArrayList.size() >= parampxe.jdField_a_of_type_Int) && (bool2)) {
        parampxe.jdField_a_of_type_Byte = 3;
      }
      if (parampxe.c)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler.a(bool1, bool2, a(paramString));
        if (!QLog.isColorLevel()) {
          break label498;
        }
        if (localObject1 == null) {
          break label562;
        }
        localObject2 = ((DiscussionInfo)localObject1).discussionName;
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (((String)localObject2).length() <= 3) {}
        }
      }
      for (localObject1 = ((String)localObject2).substring(0, 2) + "." + ((String)localObject2).charAt(((String)localObject2).length() - 1);; localObject1 = null)
      {
        QLog.d("Q.qqhead.dih", 2, "CreateIcon Done: uin=" + paramString + ", name=" + (String)localObject1 + ", state=" + parampxe.jdField_a_of_type_Byte + ", iconCount=" + parampxe.jdField_a_of_type_JavaUtilArrayList.size() + ", totalCount=" + parampxe.jdField_a_of_type_Int + ", isComplete=" + bool2 + ", faceUinSet=" + parampxe.jdField_a_of_type_JavaLangString + ", newFaceUinSet=" + str + ",hasPstnIcon: " + parampxe.c + ", hasRealPstnUser: " + parampxe.d);
        return;
        this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler.a(bool1, bool2, paramString);
        break label262;
        break;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.qqhead.dih", 2, "CreateIcon fail: " + paramString + ", iconCount=" + parampxe.jdField_a_of_type_JavaUtilArrayList.size() + ", totalCount=" + parampxe.jdField_a_of_type_Int);
        return;
      }
    }
  }
  
  public static boolean a(String paramString)
  {
    boolean bool = true;
    if ((paramString == null) || (paramString.length() == 0))
    {
      QLog.i("Q.qqhead.dih", 1, "===isPstnDiscussionUin discussionUin is null ===");
      bool = false;
    }
    while (paramString.contains("_1001")) {
      return bool;
    }
    return false;
  }
  
  private boolean a(String paramString, boolean paramBoolean)
  {
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilHashMap)
      {
        long l = System.currentTimeMillis();
        pxe localpxe;
        if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))
        {
          localpxe = (pxe)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
          if (localpxe.jdField_a_of_type_Byte == 3)
          {
            m = 1;
            if (((m == 0) && (l - localpxe.jdField_a_of_type_Long < this.k)) || ((m != 0) && (!paramBoolean) && (l - localpxe.jdField_a_of_type_Long < 3600000L))) {
              return false;
            }
            localpxe.a(localpxe.jdField_a_of_type_Byte);
            if (a(paramString))
            {
              localpxe.c = true;
              localpxe.d = PstnUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, b(paramString), 3000);
            }
            localpxe.jdField_a_of_type_Long = l;
            this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localpxe);
            return true;
          }
        }
        else
        {
          localpxe = new pxe(this, null);
          this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localpxe);
        }
      }
      int m = 0;
    }
  }
  
  /* Error */
  private Pair b(String paramString1, String paramString2, ArrayList paramArrayList, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +17 -> 18
    //   4: iconst_0
    //   5: invokestatic 179	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   8: iconst_0
    //   9: invokestatic 179	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   12: invokestatic 185	android/util/Pair:create	(Ljava/lang/Object;Ljava/lang/Object;)Landroid/util/Pair;
    //   15: astore_2
    //   16: aload_2
    //   17: areturn
    //   18: aload_1
    //   19: ifnonnull +20 -> 39
    //   22: iload 5
    //   24: ifne +15 -> 39
    //   27: iconst_0
    //   28: invokestatic 179	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   31: iconst_0
    //   32: invokestatic 179	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   35: invokestatic 185	android/util/Pair:create	(Ljava/lang/Object;Ljava/lang/Object;)Landroid/util/Pair;
    //   38: areturn
    //   39: iload 4
    //   41: ifne +703 -> 744
    //   44: aload_0
    //   45: getfield 143	com/tencent/mobileqq/app/DiscussionIconHelper:jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler	Lcom/tencent/mobileqq/app/DiscussionHandler;
    //   48: getfield 125	com/tencent/mobileqq/app/DiscussionHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   51: bipush 101
    //   53: aload_2
    //   54: iconst_0
    //   55: invokevirtual 504	com/tencent/mobileqq/app/QQAppInterface:a	(ILjava/lang/String;I)Ljava/lang/String;
    //   58: astore 8
    //   60: aload_0
    //   61: getfield 145	com/tencent/mobileqq/app/DiscussionIconHelper:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   64: bipush 101
    //   66: aload_2
    //   67: iconst_1
    //   68: iconst_0
    //   69: invokevirtual 507	com/tencent/mobileqq/app/QQAppInterface:a	(ILjava/lang/String;BI)Ljava/lang/String;
    //   72: astore 9
    //   74: iload 4
    //   76: ifeq +665 -> 741
    //   79: aload_0
    //   80: getfield 145	com/tencent/mobileqq/app/DiscussionIconHelper:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   83: sipush 1001
    //   86: aload_2
    //   87: invokestatic 441	com/tencent/mobileqq/app/DiscussionIconHelper:a	(Ljava/lang/String;)Ljava/lang/String;
    //   90: iconst_1
    //   91: iconst_0
    //   92: invokevirtual 507	com/tencent/mobileqq/app/QQAppInterface:a	(ILjava/lang/String;BI)Ljava/lang/String;
    //   95: astore 9
    //   97: aload 8
    //   99: invokestatic 512	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   102: ifne +633 -> 735
    //   105: new 514	java/io/File
    //   108: dup
    //   109: aload 8
    //   111: invokespecial 516	java/io/File:<init>	(Ljava/lang/String;)V
    //   114: astore 10
    //   116: aload_1
    //   117: ifnull +79 -> 196
    //   120: aload_1
    //   121: invokevirtual 349	java/lang/String:trim	()Ljava/lang/String;
    //   124: invokevirtual 173	java/lang/String:length	()I
    //   127: ifgt +69 -> 196
    //   130: aload 10
    //   132: ifnull +25 -> 157
    //   135: aload 10
    //   137: invokevirtual 519	java/io/File:exists	()Z
    //   140: ifeq +17 -> 157
    //   143: aload 10
    //   145: invokevirtual 522	java/io/File:isFile	()Z
    //   148: ifeq +9 -> 157
    //   151: aload 10
    //   153: invokevirtual 525	java/io/File:delete	()Z
    //   156: pop
    //   157: iload 4
    //   159: ifeq +13 -> 172
    //   162: iload 4
    //   164: ifeq +32 -> 196
    //   167: iload 5
    //   169: ifne +27 -> 196
    //   172: aload_0
    //   173: getfield 145	com/tencent/mobileqq/app/DiscussionIconHelper:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   176: aload 9
    //   178: invokestatic 530	com/tencent/mobileqq/utils/ImageUtil:g	()Landroid/graphics/Bitmap;
    //   181: invokevirtual 533	com/tencent/mobileqq/app/QQAppInterface:a	(Ljava/lang/String;Landroid/graphics/Bitmap;)V
    //   184: iconst_1
    //   185: invokestatic 179	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   188: iconst_1
    //   189: invokestatic 179	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   192: invokestatic 185	android/util/Pair:create	(Ljava/lang/Object;Ljava/lang/Object;)Landroid/util/Pair;
    //   195: areturn
    //   196: aload_0
    //   197: aload_1
    //   198: aload_2
    //   199: aload_3
    //   200: iload 4
    //   202: iload 5
    //   204: invokespecial 535	com/tencent/mobileqq/app/DiscussionIconHelper:a	(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;ZZ)Landroid/util/Pair;
    //   207: astore_3
    //   208: aload_3
    //   209: getfield 266	android/util/Pair:second	Ljava/lang/Object;
    //   212: checkcast 245	android/graphics/Bitmap
    //   215: astore 11
    //   217: aload_3
    //   218: getfield 251	android/util/Pair:first	Ljava/lang/Object;
    //   221: checkcast 175	java/lang/Boolean
    //   224: invokevirtual 254	java/lang/Boolean:booleanValue	()Z
    //   227: istore 16
    //   229: aload 11
    //   231: ifnonnull +25 -> 256
    //   234: iconst_0
    //   235: invokestatic 179	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   238: iconst_0
    //   239: invokestatic 179	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   242: invokestatic 185	android/util/Pair:create	(Ljava/lang/Object;Ljava/lang/Object;)Landroid/util/Pair;
    //   245: areturn
    //   246: astore_3
    //   247: iconst_1
    //   248: istore 16
    //   250: aconst_null
    //   251: astore 11
    //   253: goto -24 -> 229
    //   256: aconst_null
    //   257: astore 12
    //   259: aconst_null
    //   260: astore 13
    //   262: aconst_null
    //   263: astore 14
    //   265: iload 4
    //   267: ifeq +271 -> 538
    //   270: iconst_1
    //   271: istore 17
    //   273: iload 17
    //   275: istore 15
    //   277: aload 14
    //   279: astore_3
    //   280: aload 12
    //   282: astore 6
    //   284: aload 13
    //   286: astore 7
    //   288: aload_0
    //   289: getfield 119	com/tencent/mobileqq/app/DiscussionIconHelper:jdField_b_of_type_JavaUtilSet	Ljava/util/Set;
    //   292: ifnull +46 -> 338
    //   295: aload 12
    //   297: astore 6
    //   299: aload 13
    //   301: astore 7
    //   303: aload_0
    //   304: getfield 119	com/tencent/mobileqq/app/DiscussionIconHelper:jdField_b_of_type_JavaUtilSet	Ljava/util/Set;
    //   307: astore_3
    //   308: aload 12
    //   310: astore 6
    //   312: aload 13
    //   314: astore 7
    //   316: aload_3
    //   317: monitorenter
    //   318: aload_0
    //   319: getfield 119	com/tencent/mobileqq/app/DiscussionIconHelper:jdField_b_of_type_JavaUtilSet	Ljava/util/Set;
    //   322: aload_2
    //   323: invokeinterface 243 2 0
    //   328: pop
    //   329: aload_3
    //   330: monitorexit
    //   331: aload 14
    //   333: astore_3
    //   334: iload 17
    //   336: istore 15
    //   338: aload_3
    //   339: astore 6
    //   341: aload_3
    //   342: astore 7
    //   344: invokestatic 538	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   347: ifeq +94 -> 441
    //   350: aload_3
    //   351: astore 6
    //   353: aload_3
    //   354: astore 7
    //   356: ldc 16
    //   358: iconst_4
    //   359: new 85	java/lang/StringBuilder
    //   362: dup
    //   363: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   366: ldc_w 540
    //   369: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: iload 15
    //   374: invokevirtual 219	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   377: ldc_w 542
    //   380: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   383: aload_2
    //   384: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   387: ldc_w 542
    //   390: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: aload_1
    //   394: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: ldc_w 542
    //   400: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   403: aload 8
    //   405: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   408: ldc 94
    //   410: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   413: ldc_w 544
    //   416: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: iload 4
    //   421: invokevirtual 219	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   424: ldc_w 546
    //   427: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   430: iload 5
    //   432: invokevirtual 219	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   435: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   438: invokestatic 290	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   441: aload_3
    //   442: astore 6
    //   444: aload_3
    //   445: astore 7
    //   447: aload_0
    //   448: getfield 145	com/tencent/mobileqq/app/DiscussionIconHelper:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   451: aload 9
    //   453: aload 11
    //   455: invokevirtual 533	com/tencent/mobileqq/app/QQAppInterface:a	(Ljava/lang/String;Landroid/graphics/Bitmap;)V
    //   458: iload 15
    //   460: istore 4
    //   462: aload_3
    //   463: ifnull +11 -> 474
    //   466: aload_3
    //   467: invokevirtual 551	java/io/BufferedOutputStream:close	()V
    //   470: iload 15
    //   472: istore 4
    //   474: iload 4
    //   476: invokestatic 179	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   479: iload 16
    //   481: invokestatic 179	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   484: invokestatic 185	android/util/Pair:create	(Ljava/lang/Object;Ljava/lang/Object;)Landroid/util/Pair;
    //   487: areturn
    //   488: astore_1
    //   489: aload_3
    //   490: monitorexit
    //   491: aload 12
    //   493: astore 6
    //   495: aload 13
    //   497: astore 7
    //   499: aload_1
    //   500: athrow
    //   501: astore_1
    //   502: iconst_0
    //   503: istore 5
    //   505: iload 5
    //   507: istore 4
    //   509: aload 6
    //   511: ifnull -37 -> 474
    //   514: aload 6
    //   516: invokevirtual 551	java/io/BufferedOutputStream:close	()V
    //   519: iload 5
    //   521: istore 4
    //   523: goto -49 -> 474
    //   526: astore_1
    //   527: aload_1
    //   528: invokevirtual 554	java/lang/Throwable:printStackTrace	()V
    //   531: iload 5
    //   533: istore 4
    //   535: goto -61 -> 474
    //   538: aload 10
    //   540: ifnonnull +75 -> 615
    //   543: aload 12
    //   545: astore 6
    //   547: aload 13
    //   549: astore 7
    //   551: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   554: ifeq +20 -> 574
    //   557: aload 12
    //   559: astore 6
    //   561: aload 13
    //   563: astore 7
    //   565: ldc 16
    //   567: iconst_2
    //   568: ldc_w 556
    //   571: invokestatic 290	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   574: aload 12
    //   576: astore 6
    //   578: aload 13
    //   580: astore 7
    //   582: iconst_0
    //   583: invokestatic 179	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   586: iconst_0
    //   587: invokestatic 179	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   590: invokestatic 185	android/util/Pair:create	(Ljava/lang/Object;Ljava/lang/Object;)Landroid/util/Pair;
    //   593: astore_1
    //   594: aload_1
    //   595: astore_2
    //   596: iconst_0
    //   597: ifeq -581 -> 16
    //   600: new 558	java/lang/NullPointerException
    //   603: dup
    //   604: invokespecial 559	java/lang/NullPointerException:<init>	()V
    //   607: athrow
    //   608: astore_2
    //   609: aload_2
    //   610: invokevirtual 554	java/lang/Throwable:printStackTrace	()V
    //   613: aload_1
    //   614: areturn
    //   615: aload 12
    //   617: astore 6
    //   619: aload 13
    //   621: astore 7
    //   623: aload 10
    //   625: invokevirtual 519	java/io/File:exists	()Z
    //   628: ifne +17 -> 645
    //   631: aload 12
    //   633: astore 6
    //   635: aload 13
    //   637: astore 7
    //   639: aload 10
    //   641: invokevirtual 562	java/io/File:createNewFile	()Z
    //   644: pop
    //   645: aload 12
    //   647: astore 6
    //   649: aload 13
    //   651: astore 7
    //   653: new 548	java/io/BufferedOutputStream
    //   656: dup
    //   657: new 564	java/io/FileOutputStream
    //   660: dup
    //   661: aload 10
    //   663: invokespecial 567	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   666: invokespecial 570	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   669: astore_3
    //   670: aload 11
    //   672: getstatic 576	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   675: bipush 90
    //   677: aload_3
    //   678: invokevirtual 580	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   681: istore 15
    //   683: aload_3
    //   684: invokevirtual 583	java/io/BufferedOutputStream:flush	()V
    //   687: goto -349 -> 338
    //   690: astore_1
    //   691: aload_1
    //   692: invokevirtual 554	java/lang/Throwable:printStackTrace	()V
    //   695: iload 15
    //   697: istore 4
    //   699: goto -225 -> 474
    //   702: astore_1
    //   703: aload 7
    //   705: astore_3
    //   706: aload_3
    //   707: ifnull +7 -> 714
    //   710: aload_3
    //   711: invokevirtual 551	java/io/BufferedOutputStream:close	()V
    //   714: aload_1
    //   715: athrow
    //   716: astore_2
    //   717: aload_2
    //   718: invokevirtual 554	java/lang/Throwable:printStackTrace	()V
    //   721: goto -7 -> 714
    //   724: astore_1
    //   725: goto -19 -> 706
    //   728: astore_1
    //   729: aload_3
    //   730: astore 6
    //   732: goto -230 -> 502
    //   735: aconst_null
    //   736: astore 10
    //   738: goto -622 -> 116
    //   741: goto -644 -> 97
    //   744: aconst_null
    //   745: astore 8
    //   747: goto -687 -> 60
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	750	0	this	DiscussionIconHelper
    //   0	750	1	paramString1	String
    //   0	750	2	paramString2	String
    //   0	750	3	paramArrayList	ArrayList
    //   0	750	4	paramBoolean1	boolean
    //   0	750	5	paramBoolean2	boolean
    //   282	449	6	localObject1	Object
    //   286	418	7	localObject2	Object
    //   58	688	8	str1	String
    //   72	380	9	str2	String
    //   114	623	10	localFile	java.io.File
    //   215	456	11	localBitmap	Bitmap
    //   257	389	12	localObject3	Object
    //   260	390	13	localObject4	Object
    //   263	69	14	localObject5	Object
    //   275	421	15	bool1	boolean
    //   227	253	16	bool2	boolean
    //   271	64	17	bool3	boolean
    // Exception table:
    //   from	to	target	type
    //   196	229	246	java/lang/Throwable
    //   318	331	488	finally
    //   489	491	488	finally
    //   288	295	501	java/lang/Throwable
    //   303	308	501	java/lang/Throwable
    //   316	318	501	java/lang/Throwable
    //   344	350	501	java/lang/Throwable
    //   356	441	501	java/lang/Throwable
    //   447	458	501	java/lang/Throwable
    //   499	501	501	java/lang/Throwable
    //   551	557	501	java/lang/Throwable
    //   565	574	501	java/lang/Throwable
    //   582	594	501	java/lang/Throwable
    //   623	631	501	java/lang/Throwable
    //   639	645	501	java/lang/Throwable
    //   653	670	501	java/lang/Throwable
    //   514	519	526	java/lang/Throwable
    //   600	608	608	java/lang/Throwable
    //   466	470	690	java/lang/Throwable
    //   288	295	702	finally
    //   303	308	702	finally
    //   316	318	702	finally
    //   344	350	702	finally
    //   356	441	702	finally
    //   447	458	702	finally
    //   499	501	702	finally
    //   551	557	702	finally
    //   565	574	702	finally
    //   582	594	702	finally
    //   623	631	702	finally
    //   639	645	702	finally
    //   653	670	702	finally
    //   710	714	716	java/lang/Throwable
    //   670	687	724	finally
    //   670	687	728	java/lang/Throwable
  }
  
  public static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.i("Q.qqhead.dih", 1, "===getDiscussionUinFromPstn pstnDiscussionUin is null ===");
      return null;
    }
    int m = paramString.indexOf("_");
    if ((m < 0) || (m > paramString.length()))
    {
      QLog.i("Q.qqhead.dih", 1, "===getDiscussionUinFromPstn pstnDiscussionUin is invalid, pstnDiscussionUin | " + paramString);
      return null;
    }
    return paramString.substring(0, m);
  }
  
  private void h(String paramString)
  {
    this.jdField_a_of_type_Pxg.removeMessages(9527, paramString);
    paramString = this.jdField_a_of_type_Pxg.obtainMessage(9527, paramString);
    this.jdField_a_of_type_Pxg.sendMessageDelayed(paramString, 300L);
  }
  
  /* Error */
  public Bitmap a(int paramInt, Bitmap[] paramArrayOfBitmap)
  {
    // Byte code:
    //   0: invokestatic 616	com/tencent/common/app/BaseApplicationImpl:a	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   3: invokevirtual 617	com/tencent/common/app/BaseApplicationImpl:getResources	()Landroid/content/res/Resources;
    //   6: ldc_w 618
    //   9: invokestatic 624	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   12: astore 4
    //   14: iload_1
    //   15: aload_2
    //   16: aload 4
    //   18: fconst_1
    //   19: invokestatic 629	com/tencent/mobileqq/util/PuzzleAvatarUtil:a	(I[Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;F)Landroid/graphics/Bitmap;
    //   22: astore_2
    //   23: aload_2
    //   24: astore_3
    //   25: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   28: ifeq +38 -> 66
    //   31: aload_2
    //   32: astore_3
    //   33: aload_2
    //   34: ifnonnull +32 -> 66
    //   37: ldc 16
    //   39: iconst_2
    //   40: new 85	java/lang/StringBuilder
    //   43: dup
    //   44: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   47: ldc_w 631
    //   50: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: aload 4
    //   55: invokevirtual 634	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   58: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: invokestatic 290	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   64: aload_2
    //   65: astore_3
    //   66: aload_3
    //   67: areturn
    //   68: astore 4
    //   70: aconst_null
    //   71: astore_2
    //   72: aload_2
    //   73: astore_3
    //   74: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   77: ifeq -11 -> 66
    //   80: ldc 16
    //   82: iconst_2
    //   83: aload 4
    //   85: invokevirtual 635	java/lang/Exception:toString	()Ljava/lang/String;
    //   88: invokestatic 290	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   91: aload_2
    //   92: areturn
    //   93: astore 4
    //   95: aconst_null
    //   96: astore_2
    //   97: aload_2
    //   98: astore_3
    //   99: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   102: ifeq -36 -> 66
    //   105: ldc 16
    //   107: iconst_2
    //   108: aload 4
    //   110: invokevirtual 636	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   113: invokestatic 290	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   116: aload_2
    //   117: areturn
    //   118: astore 4
    //   120: aconst_null
    //   121: astore_2
    //   122: aload_2
    //   123: astore_3
    //   124: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   127: ifeq -61 -> 66
    //   130: ldc 16
    //   132: iconst_2
    //   133: aload 4
    //   135: invokevirtual 637	java/lang/Error:toString	()Ljava/lang/String;
    //   138: invokestatic 290	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   141: aload_2
    //   142: areturn
    //   143: astore 4
    //   145: goto -23 -> 122
    //   148: astore 4
    //   150: goto -53 -> 97
    //   153: astore 4
    //   155: goto -83 -> 72
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	158	0	this	DiscussionIconHelper
    //   0	158	1	paramInt	int
    //   0	158	2	paramArrayOfBitmap	Bitmap[]
    //   24	100	3	arrayOfBitmap	Bitmap[]
    //   12	42	4	localBitmap	Bitmap
    //   68	16	4	localException1	Exception
    //   93	16	4	localOutOfMemoryError1	OutOfMemoryError
    //   118	16	4	localError1	Error
    //   143	1	4	localError2	Error
    //   148	1	4	localOutOfMemoryError2	OutOfMemoryError
    //   153	1	4	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   0	23	68	java/lang/Exception
    //   0	23	93	java/lang/OutOfMemoryError
    //   0	23	118	java/lang/Error
    //   25	31	143	java/lang/Error
    //   37	64	143	java/lang/Error
    //   25	31	148	java/lang/OutOfMemoryError
    //   37	64	148	java/lang/OutOfMemoryError
    //   25	31	153	java/lang/Exception
    //   37	64	153	java/lang/Exception
  }
  
  public void a(long paramLong) {}
  
  public void a(boolean paramBoolean, int paramInt) {}
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.dih", 2, "onUpdateCustomHead isSuccess | " + paramBoolean + ", uin=");
    }
    ArrayList localArrayList = null;
    label400:
    label403:
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilHashMap)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
        if (localIterator.hasNext())
        {
          String str1 = (String)localIterator.next();
          pxe localpxe = (pxe)this.jdField_a_of_type_JavaUtilHashMap.get(str1);
          if ((localpxe == null) || (localpxe.jdField_a_of_type_JavaLangString == null)) {
            continue;
          }
          if (localpxe.c)
          {
            str2 = localpxe.jdField_a_of_type_JavaLangString;
            if ((!paramBoolean) || (!str2.contains(paramString))) {
              break label403;
            }
            if (QLog.isColorLevel()) {
              QLog.d("Q.qqhead.dih", 2, "onUpdateCustomHead pstn: disUin=" + str1 + ", uin=" + paramString + ", faceUinSet=" + str2);
            }
            if (localpxe.jdField_a_of_type_Byte != 3)
            {
              localpxe.jdField_a_of_type_JavaUtilArrayList.add(paramString);
              h(str1);
              break label403;
            }
            if (localArrayList != null) {
              break label400;
            }
            localArrayList = new ArrayList();
            localArrayList.add(str1);
            break label403;
          }
          if (localpxe.jdField_a_of_type_Byte == 3) {
            continue;
          }
          String str2 = localpxe.jdField_a_of_type_JavaLangString;
          if ((!paramBoolean) || (!str2.contains(paramString))) {
            continue;
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.qqhead.dih", 2, "onUpdateCustomHead: disUin=" + str1 + ", uin=" + paramString + ", faceUinSet=" + str2);
          }
          localpxe.jdField_a_of_type_JavaUtilArrayList.add(paramString);
          h(str1);
        }
      }
      if ((localArrayList != null) && (localArrayList.size() > 0))
      {
        paramString = localArrayList.iterator();
        while (paramString.hasNext()) {
          f(b((String)paramString.next()));
        }
      }
      return;
    }
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void b(int paramInt) {}
  
  public void b(String paramString)
  {
    boolean bool = a(paramString, true);
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.dih", 2, "createDisIcon: " + paramString + ", isNeedToDo=" + bool);
    }
    if (bool) {
      h(paramString);
    }
  }
  
  public void c(int paramInt) {}
  
  public void c(String paramString)
  {
    boolean bool = a(paramString, false);
    if (bool)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqhead.dih", 2, "checkDisIcon: " + paramString + ", isNeedToDo=" + bool);
      }
      paramString = new pxf(this, 1, paramString);
      ThreadManager.a().post(paramString);
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.dih", 2, "DiscussionIconHelper release.");
    }
    if (this.jdField_a_of_type_Pxc != null) {
      this.jdField_a_of_type_Pxc.jdField_a_of_type_Boolean = false;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaLangObject.notifyAll();
      synchronized (this.jdField_a_of_type_JavaUtilHashMap)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          pxe localpxe = (pxe)this.jdField_a_of_type_JavaUtilHashMap.get(str);
          if ((localpxe != null) && (localpxe.jdField_a_of_type_Byte != 3)) {
            this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler.a(false, true, str);
          }
        }
      }
    }
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    ??? = (PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
    if (??? != null) {
      ((PhoneContactManagerImp)???).b(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this);
  }
  
  public void d(int paramInt)
  {
    if ((paramInt == 1) && (this.jdField_a_of_type_JavaUtilSet != null)) {
      for (;;)
      {
        synchronized (this.jdField_a_of_type_JavaUtilSet)
        {
          if (this.jdField_a_of_type_JavaUtilSet.size() > 0)
          {
            ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilSet);
            int m = localArrayList.size();
            paramInt = 0;
            if (paramInt < m)
            {
              String str = (String)localArrayList.get(paramInt);
              if ((str != null) && (str.length() != 0)) {
                f(str);
              }
            }
            else
            {
              this.jdField_a_of_type_JavaUtilSet.clear();
            }
          }
          else
          {
            return;
          }
        }
        paramInt += 1;
      }
    }
  }
  
  public void d(String paramString)
  {
    long l = System.currentTimeMillis();
    if ((this.jdField_a_of_type_JavaUtilHashtable.containsKey(paramString)) && (l - ((Long)this.jdField_a_of_type_JavaUtilHashtable.get(paramString)).longValue() < this.j)) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqhead.dih", 2, "refreshDisIcon repeat: " + paramString);
      }
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqhead.dih", 2, "refreshDisIcon: " + paramString);
      }
      this.jdField_a_of_type_JavaUtilHashtable.put(paramString, Long.valueOf(l));
      ??? = new pxf(this, 3, paramString);
      ThreadManager.a().post((Runnable)???);
    } while ((this.jdField_b_of_type_JavaUtilSet == null) || (!this.jdField_b_of_type_JavaUtilSet.contains(paramString)));
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.dih", 2, "refreshDisIcon mDisCallUinSet has it " + paramString);
    }
    synchronized (this.jdField_b_of_type_JavaUtilSet)
    {
      this.jdField_b_of_type_JavaUtilSet.remove(paramString);
      f(paramString);
      return;
    }
  }
  
  public void e(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.dih", 2, "removeDiscussion: " + paramString);
    }
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      this.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
      return;
    }
  }
  
  public void f(String paramString)
  {
    String str = a(paramString);
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(str))
    {
      e(str);
      paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1001, a(paramString), (byte)1, 0);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramString);
      b(str);
    }
  }
  
  public void g(String paramString)
  {
    ??? = PstnUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, 3000);
    if (((??? == null) || (((String)???).length() == 0)) && (this.jdField_a_of_type_JavaUtilSet.contains(paramString))) {}
    synchronized (this.jdField_a_of_type_JavaUtilSet)
    {
      this.jdField_a_of_type_JavaUtilSet.remove(paramString);
      f(paramString);
      return;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      paramMessage = new pxf(this, 2, (String)paramMessage.obj);
      ThreadManager.a().post(paramMessage);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\DiscussionIconHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */