package com.tencent.mobileqq.util;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CardProfile;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;

public class VoteUtil
{
  public static final int a = 0;
  public static final String a = VoteUtil.class.getSimpleName();
  public static final int b = 1;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static CardProfile a(QQAppInterface paramQQAppInterface, long paramLong, int paramInt)
  {
    boolean bool = true;
    CardProfile localCardProfile = null;
    Object localObject = paramQQAppInterface.a().createEntityManager();
    paramQQAppInterface = localCardProfile;
    if (localObject != null)
    {
      localCardProfile = (CardProfile)((EntityManager)localObject).a(CardProfile.class, "lEctID=? and type=?", new String[] { Long.toString(paramLong), Integer.toString(paramInt) });
      paramQQAppInterface = localCardProfile;
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = a;
        localObject = new StringBuilder().append("readFromDb. uin:").append(paramLong).append(" find:");
        if (localCardProfile == null) {
          break label116;
        }
      }
    }
    for (;;)
    {
      QLog.i(paramQQAppInterface, 2, bool);
      paramQQAppInterface = localCardProfile;
      return paramQQAppInterface;
      label116:
      bool = false;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, int paramInt)
  {
    Object localObject1 = paramQQAppInterface.a().createEntityManager();
    Object localObject2;
    if (localObject1 != null)
    {
      paramQQAppInterface = (CardProfile)((EntityManager)localObject1).a(CardProfile.class, "lEctID=? and type=?", new String[] { Long.toString(paramLong), Integer.toString(2) });
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface.bAvailableCnt -= paramInt;
        paramQQAppInterface.bTodayVotedCnt += paramInt;
        if (paramQQAppInterface.getStatus() != 1000) {
          break label243;
        }
        ((EntityManager)localObject1).b(paramQQAppInterface);
      }
      localObject2 = (CardProfile)((EntityManager)localObject1).a(CardProfile.class, "lEctID=? and type=?", new String[] { Long.toString(paramLong), Integer.toString(3) });
      if (localObject2 != null)
      {
        ((CardProfile)localObject2).bAvailableCnt -= paramInt;
        ((CardProfile)localObject2).bTodayVotedCnt += paramInt;
        ((CardProfile)localObject2).bVoteCnt = ((short)(int)((CardProfile)localObject2).bTodayVotedCnt);
        if (((CardProfile)localObject2).getStatus() != 1000) {
          break label253;
        }
        ((EntityManager)localObject1).b((Entity)localObject2);
      }
      label180:
      ((EntityManager)localObject1).a();
      if (QLog.isColorLevel())
      {
        localObject1 = a;
        localObject2 = new StringBuilder().append("updateProfileCardVote. uin:").append(paramLong).append(" find:");
        if (paramQQAppInterface == null) {
          break label264;
        }
      }
    }
    label243:
    label253:
    label264:
    for (boolean bool = true;; bool = false)
    {
      QLog.i((String)localObject1, 2, bool);
      return;
      ((EntityManager)localObject1).a(paramQQAppInterface);
      break;
      ((EntityManager)localObject1).a((Entity)localObject2);
      break label180;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\util\VoteUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */