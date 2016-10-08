package friendlist;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Serializable;

public final class EUserAddFriendSetting
  implements Serializable
{
  public static final int _eAfterAnswerQuestionCorrectly = 100;
  public static final int _eAllowEveryone = 0;
  public static final int _eFriendAlready = 101;
  public static final int _eNeedAnswerQuestion = 3;
  public static final int _eNeedAnswerQuestionAndAudit = 4;
  public static final int _eNeedVerify = 1;
  public static final int _eRefuseEveryone = 2;
  
  public EUserAddFriendSetting()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\friendlist\EUserAddFriendSetting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */