package com.tencent.biz.TroopRedpoint;

import com.tencent.biz.now.NowLiveManager;
import com.tencent.mobileqq.activity.leba.LebaShowListManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import hfv;
import mqq.manager.Manager;
import tencent.im.oidb.cmd0x791.oidb_0x791.GetRedDotRes;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;

public class TroopRedTouchManager
  implements Manager
{
  public QQAppInterface a;
  final String jdField_a_of_type_JavaLangString;
  oidb_0x791.GetRedDotRes jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes;
  boolean jdField_a_of_type_Boolean;
  public final String b;
  
  public TroopRedTouchManager(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = "TroopRedTouchManager";
    this.b = TroopRedTouchManager.class.getSimpleName();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public TroopRedTouchManager(QQAppInterface paramQQAppInterface, oidb_0x791.GetRedDotRes paramGetRedDotRes)
  {
    this.jdField_a_of_type_JavaLangString = "TroopRedTouchManager";
    this.b = TroopRedTouchManager.class.getSimpleName();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes = paramGetRedDotRes;
  }
  
  public static String a(oidb_0x791.RedDotInfo paramRedDotInfo)
  {
    if (paramRedDotInfo == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder("redDotInfo2String, oidb_0x791.RedDotInfo:");
    localStringBuilder.append("uint32_appid:").append(paramRedDotInfo.uint32_appid.get()).append("|redDotInfo.bool_display_reddot:").append(paramRedDotInfo.bool_display_reddot.get()).append("|uint32_number:").append(paramRedDotInfo.uint32_number.get()).append("|uint32_reason:").append(paramRedDotInfo.uint32_reason.get()).append("|uint32_last_time:").append(paramRedDotInfo.uint32_last_time.get()).append("|uint64_cmd_uin:").append(paramRedDotInfo.uint64_cmd_uin.get()).append("|str_face_url:").append(paramRedDotInfo.str_face_url.get().toStringUtf8()).append("|str_custom_buffer:").append(paramRedDotInfo.str_custom_buffer.get().toStringUtf8()).append("|uint32_expire_time:").append(paramRedDotInfo.uint32_expire_time.get());
    return localStringBuilder.toString();
  }
  
  /* Error */
  private oidb_0x791.GetRedDotRes a()
  {
    // Byte code:
    //   0: new 152	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: getfield 38	com/tencent/biz/TroopRedpoint/TroopRedTouchManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   8: invokevirtual 158	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   11: invokevirtual 164	mqq/app/MobileQQ:getFilesDir	()Ljava/io/File;
    //   14: new 47	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 165	java/lang/StringBuilder:<init>	()V
    //   21: ldc 24
    //   23: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: aload_0
    //   27: getfield 38	com/tencent/biz/TroopRedpoint/TroopRedTouchManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   30: invokevirtual 167	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   33: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokespecial 170	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   42: invokestatic 175	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/io/File;)[B
    //   45: astore_2
    //   46: new 177	tencent/im/oidb/cmd0x791/oidb_0x791$GetRedDotRes
    //   49: dup
    //   50: invokespecial 178	tencent/im/oidb/cmd0x791/oidb_0x791$GetRedDotRes:<init>	()V
    //   53: astore_1
    //   54: aload_2
    //   55: ifnull +9 -> 64
    //   58: aload_1
    //   59: aload_2
    //   60: invokevirtual 182	tencent/im/oidb/cmd0x791/oidb_0x791$GetRedDotRes:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   63: pop
    //   64: aload_1
    //   65: areturn
    //   66: astore_2
    //   67: aconst_null
    //   68: astore_1
    //   69: aload_2
    //   70: invokevirtual 185	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   73: aload_1
    //   74: areturn
    //   75: astore_2
    //   76: aconst_null
    //   77: astore_1
    //   78: aload_2
    //   79: invokevirtual 186	java/lang/NullPointerException:printStackTrace	()V
    //   82: aload_1
    //   83: areturn
    //   84: astore_2
    //   85: goto -7 -> 78
    //   88: astore_2
    //   89: goto -20 -> 69
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	92	0	this	TroopRedTouchManager
    //   53	30	1	localGetRedDotRes	oidb_0x791.GetRedDotRes
    //   45	15	2	arrayOfByte	byte[]
    //   66	4	2	localInvalidProtocolBufferMicroException1	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   75	4	2	localNullPointerException1	NullPointerException
    //   84	1	2	localNullPointerException2	NullPointerException
    //   88	1	2	localInvalidProtocolBufferMicroException2	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    // Exception table:
    //   from	to	target	type
    //   0	54	66	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   0	54	75	java/lang/NullPointerException
    //   58	64	84	java/lang/NullPointerException
    //   58	64	88	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  private void b(oidb_0x791.GetRedDotRes paramGetRedDotRes)
  {
    if (paramGetRedDotRes == null) {
      return;
    }
    ThreadManager.a(new hfv(this, paramGetRedDotRes), 5, null, false);
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes == null) {
      this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes = a();
    }
    if (this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes == null) {
      return 0;
    }
    int i = 0;
    int j = 0;
    if (i < this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.size())
    {
      oidb_0x791.RedDotInfo localRedDotInfo = (oidb_0x791.RedDotInfo)this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.get(i);
      int k;
      if (!localRedDotInfo.bool_display_reddot.get()) {
        k = j;
      }
      for (;;)
      {
        i += 1;
        j = k;
        break;
        int m = localRedDotInfo.uint32_appid.get();
        if ((1 != m) && (6 != m) && (2 != m) && (3 != m) && (4 != m) && (5 != m))
        {
          k = j;
          if (TroopRedTouchConfigure.a(m))
          {
            k = j;
            if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().jdField_a_of_type_Boolean)
            {
              k = j;
              if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b)
              {
                k = j;
                if (a() == null) {}
              }
            }
          }
        }
        else
        {
          k = j + 1;
        }
      }
    }
    return j;
  }
  
  public oidb_0x791.RedDotInfo a()
  {
    for (;;)
    {
      int i;
      try
      {
        if (this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes == null) {
          this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes = a();
        }
        Object localObject1 = this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes;
        if (localObject1 == null)
        {
          localObject1 = null;
          return (oidb_0x791.RedDotInfo)localObject1;
        }
        i = 0;
        if (i < this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.size())
        {
          oidb_0x791.RedDotInfo localRedDotInfo = (oidb_0x791.RedDotInfo)this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.get(i);
          if ((!localRedDotInfo.bool_display_reddot.get()) || ((localRedDotInfo.uint32_expire_time.has()) && (localRedDotInfo.uint32_expire_time.get() != 0) && (localRedDotInfo.uint32_expire_time.get() < NetConnInfoCenter.getServerTime())))
          {
            if (!QLog.isColorLevel()) {
              break label209;
            }
            QLog.d("Q.qqstory.redPoint", 2, "continue:" + a(localRedDotInfo));
            break label209;
          }
          if (!TroopRedTouchConfigure.a(localRedDotInfo.uint32_appid.get())) {
            break label209;
          }
          localObject1 = localRedDotInfo;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("Q.qqstory.redPoint", 2, "return:" + a(localRedDotInfo));
          localObject1 = localRedDotInfo;
          continue;
        }
        Object localObject3 = null;
      }
      finally {}
      continue;
      label209:
      i += 1;
    }
  }
  
  public oidb_0x791.RedDotInfo a(int paramInt)
  {
    if (this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes == null) {
      this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes = a();
    }
    if (this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes == null) {
      return null;
    }
    int i = 0;
    oidb_0x791.RedDotInfo localRedDotInfo;
    if (i < this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.size())
    {
      localRedDotInfo = (oidb_0x791.RedDotInfo)this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.get(i);
      if ((paramInt != localRedDotInfo.uint32_appid.get()) || (!localRedDotInfo.bool_display_reddot.get())) {}
    }
    for (;;)
    {
      return localRedDotInfo;
      i += 1;
      break;
      localRedDotInfo = null;
    }
  }
  
  public void a()
  {
    for (;;)
    {
      int i;
      try
      {
        if (this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes == null) {
          this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes = a();
        }
        Object localObject1 = this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes;
        if (localObject1 == null) {
          return;
        }
        localObject1 = new StringBuilder("clearStoryRedPoint==>");
        i = this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.size() - 1;
        if (i >= 0)
        {
          oidb_0x791.RedDotInfo localRedDotInfo = (oidb_0x791.RedDotInfo)this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.get(i);
          if ((!localRedDotInfo.bool_display_reddot.get()) || (!TroopRedTouchConfigure.a(localRedDotInfo.uint32_appid.get()))) {
            break label207;
          }
          this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.remove(i);
          TroopRedTouchHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRedDotInfo);
          ((StringBuilder)localObject1).append(a(localRedDotInfo)).append("|");
        }
      }
      finally {}
      b(this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes);
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().jdField_a_of_type_Boolean) {
        LebaShowListManager.d |= 0x2;
      }
      if (QLog.isColorLevel())
      {
        QLog.d(this.b + "Q.qqstory.redPoint", 2, ((StringBuilder)localObject2).toString());
        continue;
        label207:
        i -= 1;
      }
    }
  }
  
  public void a(oidb_0x791.GetRedDotRes paramGetRedDotRes)
  {
    this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes = paramGetRedDotRes;
    b(paramGetRedDotRes);
  }
  
  public void a(oidb_0x791.RedDotInfo paramRedDotInfo)
  {
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes == null) {
          this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes = a();
        }
        oidb_0x791.GetRedDotRes localGetRedDotRes = this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes;
        if ((localGetRedDotRes == null) || (paramRedDotInfo == null)) {
          return;
        }
        i = 0;
        if (i >= this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.size()) {
          break label131;
        }
        if (((oidb_0x791.RedDotInfo)this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.get(i)).uint32_appid.get() == paramRedDotInfo.uint32_appid.get())
        {
          this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.set(i, paramRedDotInfo);
          i = 1;
          if (i == 0) {
            this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.add(paramRedDotInfo);
          }
          b(this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes);
          continue;
        }
        i += 1;
      }
      finally {}
      continue;
      label131:
      int i = 0;
    }
  }
  
  public boolean a(int paramInt)
  {
    if (paramInt == 0) {}
    do
    {
      return false;
      if (this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes == null) {
        this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes = a();
      }
    } while (this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes == null);
    int i = 0;
    label30:
    oidb_0x791.RedDotInfo localRedDotInfo;
    if (i < this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.size())
    {
      localRedDotInfo = (oidb_0x791.RedDotInfo)this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.get(i);
      if (localRedDotInfo.bool_display_reddot.get()) {
        break label76;
      }
    }
    label76:
    do
    {
      do
      {
        i += 1;
        break label30;
        break;
      } while (localRedDotInfo.uint32_appid.get() != paramInt);
      if (paramInt != 7) {
        return true;
      }
    } while (localRedDotInfo.uint32_number.get() <= 0);
    return true;
  }
  
  public boolean a(long paramLong)
  {
    label77:
    for (;;)
    {
      try
      {
        if (a() != null) {
          if (a().uint32_last_time.get() < paramLong)
          {
            break label77;
            if (QLog.isColorLevel()) {
              QLog.d("Q.qqstory.redPoint", 2, "isStoryRedPointNew, re ==>" + bool);
            }
            return bool;
          }
          else
          {
            bool = false;
            continue;
          }
        }
        boolean bool = true;
      }
      finally {}
    }
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes == null) {
      this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes = a();
    }
    if (this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes == null) {
      return 0;
    }
    int i = 0;
    int j = 0;
    if (i < this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.size())
    {
      oidb_0x791.RedDotInfo localRedDotInfo = (oidb_0x791.RedDotInfo)this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.get(i);
      int k;
      if (!localRedDotInfo.bool_display_reddot.get()) {
        k = j;
      }
      for (;;)
      {
        i += 1;
        j = k;
        break;
        k = j;
        if (localRedDotInfo.uint32_number.get() > 0)
        {
          k = j;
          if (7 == localRedDotInfo.uint32_appid.get()) {
            k = j + localRedDotInfo.uint32_number.get();
          }
        }
      }
    }
    return j;
  }
  
  public int c()
  {
    int i = 0;
    int k = 0;
    for (;;)
    {
      int j;
      try
      {
        if (this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes == null) {
          this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes = a();
        }
        Object localObject1 = this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes;
        if (localObject1 == null) {
          return k;
        }
        j = 0;
        k = i;
        if (j >= this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.size()) {
          continue;
        }
        localObject1 = (oidb_0x791.RedDotInfo)this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.get(j);
        if ((((oidb_0x791.RedDotInfo)localObject1).bool_display_reddot.get()) && (((oidb_0x791.RedDotInfo)localObject1).uint32_number.get() > 0) && (10 == ((oidb_0x791.RedDotInfo)localObject1).uint32_appid.get()))
        {
          k = ((oidb_0x791.RedDotInfo)localObject1).uint32_number.get();
          i = k + i;
        }
      }
      finally {}
      j += 1;
    }
  }
  
  public int d()
  {
    oidb_0x791.RedDotInfo localRedDotInfo = a();
    if (localRedDotInfo == null) {
      return 0;
    }
    switch (localRedDotInfo.uint32_appid.get())
    {
    default: 
      return 0;
    case 8: 
      return 1;
    case 9: 
      return 2;
    case 10: 
      return 3;
    }
    return 4;
  }
  
  public int e()
  {
    if (this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes == null) {
      this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes = a();
    }
    if (this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes == null) {
      return 0;
    }
    int m = 0;
    int i = 0;
    int k;
    if (m < this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.size())
    {
      oidb_0x791.RedDotInfo localRedDotInfo = (oidb_0x791.RedDotInfo)this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes.rpt_msg_reddot_info.get(m);
      int j;
      if (!localRedDotInfo.bool_display_reddot.get()) {
        j = i;
      }
      label145:
      do
      {
        do
        {
          for (;;)
          {
            m += 1;
            i = j;
            break;
            k = localRedDotInfo.uint32_appid.get();
            if ((6 == k) && (i == 0))
            {
              j = k;
            }
            else
            {
              if ((1 != k) && (2 != k) && (3 != k) && (4 != k) && (5 != k)) {
                break label145;
              }
              j = k;
            }
          }
          j = i;
        } while (localRedDotInfo.uint32_number.get() <= 0);
        j = i;
      } while (7 != localRedDotInfo.uint32_appid.get());
    }
    for (;;)
    {
      return k;
      k = i;
    }
  }
  
  public void onDestroy()
  {
    b(this.jdField_a_of_type_TencentImOidbCmd0x791Oidb_0x791$GetRedDotRes);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\TroopRedpoint\TroopRedTouchManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */