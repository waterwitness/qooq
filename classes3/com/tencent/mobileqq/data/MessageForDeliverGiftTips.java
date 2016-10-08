package com.tencent.mobileqq.data;

import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.data.TroopTipsEntity;
import com.tencent.qphone.base.util.QLog;

public class MessageForDeliverGiftTips
  extends MessageForGrayTips
{
  public static final String MESSAGERECORD_EXTSTR_TYPE = "troop_send_gift_ext_remind";
  public static final int VERSION = 1;
  public String animationBrief;
  public int animationPackageId;
  public String animationPackageUrl;
  public String bagId;
  public int exflag;
  public int giftCount;
  public int giftId;
  public String grayTipContent;
  public TroopTipsEntity grayTipsEntity;
  public boolean hasFetchButFailed;
  public String rcvName;
  public long receiverUin;
  public String remindBrief;
  public String resultText;
  public int resultType;
  public String senderName;
  public long senderUin;
  public boolean showButton;
  public String subtitle;
  public String summary;
  public int version;
  
  public MessageForDeliverGiftTips()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.subtitle = "";
    this.animationPackageUrl = "";
    this.remindBrief = "";
    this.animationBrief = "";
  }
  
  public void buildDeliverGiftTips(QQAppInterface paramQQAppInterface, Context paramContext, TextView paramTextView)
  {
    if (QLog.isColorLevel()) {
      QLog.d(".troop.send_gift", 2, "MessageForDeliverGiftTips.buildDeliverGiftTips seq:" + this.shmsgseq);
    }
    paramTextView.setText(getHightlightMsgText(paramQQAppInterface, paramContext));
    paramTextView.setClickable(true);
    paramTextView.setFocusable(true);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
  }
  
  public boolean isSupportColor()
  {
    return true;
  }
  
  public boolean isSupportImage()
  {
    return true;
  }
  
  public boolean isToAll()
  {
    return (this.animationPackageId == 0) && (this.exflag > 1000) && (this.exflag <= 2000);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\MessageForDeliverGiftTips.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */