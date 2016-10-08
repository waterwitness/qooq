package com.tencent.mobileqq.data;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.ContactUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import rbq;

public class MessageForFoldMsgGrayTips
  extends ChatMessage
{
  public static int PASSWD_REDBAG_FOLD_NICK_NUM = 20;
  public static int PASSWD_REDBAG_FOLD_STORE_NICK_LEN = 20;
  public static int PASSWD_REDBAG_MSG_DISPLAY_NUM_DEFAULT;
  public static boolean PASSWD_REDBAG_MSG_SWITCH_DEFAULT;
  private SpannableString clickSpan;
  public int foldMsgCount;
  LinkedHashSet foldUinList = new LinkedHashSet();
  ArrayList foldUinNickList = new ArrayList();
  public boolean isOpen = true;
  public String redBagId;
  public String redBagSenderNick;
  public String redBagSenderUin;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    PASSWD_REDBAG_MSG_SWITCH_DEFAULT = true;
    PASSWD_REDBAG_MSG_DISPLAY_NUM_DEFAULT = 10;
  }
  
  protected void doParse() {}
  
  public CharSequence getShowMsgContent(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    int i = (int)Long.parseLong("d13d4b", 16);
    if (this.clickSpan == null)
    {
      this.clickSpan = new SpannableString("口令红包");
      this.clickSpan.setSpan(new rbq(this, paramQQAppInterface, paramContext, i | 0xFF000000), 0, this.clickSpan.length(), 33);
    }
    this.msg = "";
    paramQQAppInterface = new SpannableStringBuilder();
    if (!this.isOpen)
    {
      paramQQAppInterface.append(String.format("此处省略%d条抢%s", new Object[] { Integer.valueOf(this.foldMsgCount), this.redBagSenderNick }));
      paramQQAppInterface.append(this.clickSpan);
      paramQQAppInterface.append("的口令");
      return paramQQAppInterface;
    }
    paramContext = new StringBuilder();
    int j = Math.min(this.foldUinNickList.size(), PASSWD_REDBAG_FOLD_NICK_NUM);
    i = 0;
    while (i < j)
    {
      int k = this.foldUinNickList.size();
      paramContext.append((String)this.foldUinNickList.get(k - 1 - i));
      if (i != j - 1) {
        paramContext.append("、");
      }
      i += 1;
    }
    if (j >= PASSWD_REDBAG_FOLD_NICK_NUM)
    {
      paramContext.append("等");
      paramContext.append(this.foldUinList.size()).append("人");
    }
    paramContext.append("也抢了").append(this.redBagSenderNick).append("发的");
    paramQQAppInterface.append(paramContext);
    paramQQAppInterface.append(this.clickSpan);
    return paramQQAppInterface;
  }
  
  public void init(QQAppInterface paramQQAppInterface, String paramString1, long paramLong, LinkedHashSet paramLinkedHashSet, String paramString2)
  {
    this.redBagId = paramString2;
    this.redBagSenderUin = String.valueOf(paramLong);
    this.redBagSenderNick = ContactUtils.b(paramQQAppInterface, paramString1, this.redBagSenderUin);
    this.foldUinList = paramLinkedHashSet;
    if (!paramLinkedHashSet.isEmpty())
    {
      Iterator localIterator = this.foldUinList.iterator();
      while (localIterator.hasNext())
      {
        paramString2 = ContactUtils.b(paramQQAppInterface, paramString1, (String)localIterator.next());
        paramLinkedHashSet = paramString2;
        if (paramString2.length() > PASSWD_REDBAG_FOLD_STORE_NICK_LEN) {
          paramLinkedHashSet = paramString2.substring(0, PASSWD_REDBAG_FOLD_STORE_NICK_LEN) + "...";
        }
        this.foldUinNickList.add(paramLinkedHashSet);
      }
    }
  }
  
  public void update(QQAppInterface paramQQAppInterface, String paramString, LinkedHashSet paramLinkedHashSet, int paramInt)
  {
    this.foldMsgCount += paramInt;
    Iterator localIterator = paramLinkedHashSet.iterator();
    while (localIterator.hasNext())
    {
      paramLinkedHashSet = (String)localIterator.next();
      if ((this.foldUinList.add(paramLinkedHashSet)) && (this.foldUinNickList.size() < PASSWD_REDBAG_FOLD_NICK_NUM))
      {
        String str = ContactUtils.b(paramQQAppInterface, paramString, paramLinkedHashSet);
        paramLinkedHashSet = str;
        if (str.length() > PASSWD_REDBAG_FOLD_STORE_NICK_LEN) {
          paramLinkedHashSet = str.substring(0, PASSWD_REDBAG_FOLD_STORE_NICK_LEN) + "...";
        }
        this.foldUinNickList.add(paramLinkedHashSet);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\MessageForFoldMsgGrayTips.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */