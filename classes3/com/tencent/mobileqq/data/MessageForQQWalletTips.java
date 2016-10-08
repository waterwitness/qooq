package com.tencent.mobileqq.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;
import com.tencent.mobileqq.activity.qwallet.PasswdRedBagManager;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;
import rbx;
import rby;

public class MessageForQQWalletTips
  extends ChatMessage
{
  public String authKey;
  public boolean bGetTroopMemberInfo;
  public String memberUin;
  public String reciverContent;
  public String reciverUin;
  public String senderContent;
  public String senderUin;
  public String summary;
  
  public MessageForQQWalletTips()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.bGetTroopMemberInfo = true;
  }
  
  private CharSequence getQQWalletTips(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    if ((paramString == null) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    PasswdRedBagManager localPasswdRedBagManager = (PasswdRedBagManager)paramQQAppInterface.getManager(124);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    StringBuilder localStringBuilder = new StringBuilder();
    Matcher localMatcher = Pattern.compile("<([^>])+").matcher(paramString);
    int i = 0;
    int j;
    int k;
    Object localObject1;
    Object localObject2;
    if (localMatcher.find())
    {
      j = localMatcher.start();
      k = localMatcher.end();
      localObject1 = paramString.substring(j + 1, k);
      localObject2 = paramString.substring(i, j);
      i = k + 1;
      localSpannableStringBuilder.append((CharSequence)localObject2);
      localStringBuilder.append((String)localObject2);
    }
    for (;;)
    {
      int n;
      int i1;
      try
      {
        localObject2 = new JSONObject((String)localObject1);
        if (((JSONObject)localObject2).has("icon"))
        {
          localObject1 = new SpannableString((CharSequence)localObject1);
          localObject2 = localPasswdRedBagManager.a();
          if (localObject2 == null) {
            break label992;
          }
          ((SpannableString)localObject1).setSpan(new rby(paramContext, (Bitmap)localObject2), 0, ((SpannableString)localObject1).length(), 1);
          localSpannableStringBuilder.append((CharSequence)localObject1);
          break label992;
        }
        if (((JSONObject)localObject2).has("uin"))
        {
          this.memberUin = ((JSONObject)localObject2).getString("uin");
          localObject1 = this.memberUin;
        }
        switch (this.istroop)
        {
        case 0: 
          localSpannableStringBuilder.append((CharSequence)localObject1);
          localStringBuilder.append((String)localObject1);
          break;
          localObject1 = ContactUtils.l(paramQQAppInterface, this.memberUin);
          break;
        case 1: 
          localObject1 = (HotChatManager)paramQQAppInterface.getManager(59);
          if ((localObject1 != null) && (((HotChatManager)localObject1).b(this.frienduin)))
          {
            localObject1 = ((FriendsManager)paramQQAppInterface.getManager(50)).c(this.memberUin);
            if ((localObject1 != null) && (((Friends)localObject1).isFriend()) && (!this.memberUin.equals(paramQQAppInterface.a())))
            {
              localObject1 = ContactUtils.b(paramQQAppInterface, this.frienduin, this.memberUin);
              continue;
            }
            localObject2 = ((JSONObject)localObject2).optString("hotname");
            if (QLog.isDevelopLevel()) {
              QLog.i("MessageForQQWalletTips", 4, "hotname=" + (String)localObject2);
            }
            localObject1 = localObject2;
            if (!TextUtils.isEmpty((CharSequence)localObject2)) {
              continue;
            }
            localObject1 = ContactUtils.b(paramQQAppInterface, this.frienduin, this.memberUin);
            continue;
          }
          localObject1 = ContactUtils.b(paramQQAppInterface, this.frienduin, this.memberUin);
          break;
        case 3000: 
          localObject1 = ((DiscussionManager)paramQQAppInterface.getManager(52)).a(this.frienduin, this.memberUin);
          if (localObject1 != null)
          {
            localObject1 = ((DiscussionMemberInfo)localObject1).inteRemark;
            continue;
          }
          localObject1 = ContactUtils.a(paramQQAppInterface, this.frienduin, this.memberUin);
          break;
        case 1000: 
          localObject1 = ContactUtils.b(paramQQAppInterface, ((TroopManager)paramQQAppInterface.getManager(51)).c(this.senderuin), this.memberUin);
          break;
        case 1004: 
          localObject1 = ContactUtils.a(paramQQAppInterface, this.senderuin, this.memberUin);
          break;
        case 1001: 
          localObject1 = ((FriendsManager)paramQQAppInterface.getManager(50)).c(this.memberUin);
          if ((localObject1 != null) && (((Friends)localObject1).isFriend()) && (!this.memberUin.equals(paramQQAppInterface.a())))
          {
            localObject1 = ContactUtils.b(paramQQAppInterface, this.frienduin, this.memberUin);
            continue;
          }
          localObject2 = ((JSONObject)localObject2).optString("hotname");
          if (QLog.isDevelopLevel()) {
            QLog.i("MessageForQQWalletTips", 4, "hotname=" + (String)localObject2);
          }
          localObject1 = localObject2;
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            continue;
          }
          localObject1 = ContactUtils.b(paramQQAppInterface, this.frienduin, this.memberUin);
          continue;
          if (!((JSONObject)localObject2).has("cmd")) {
            break label936;
          }
          SpannableString localSpannableString = new SpannableString(((JSONObject)localObject2).getString("text"));
          int m = (int)Long.parseLong(((JSONObject)localObject2).getString("textColor").substring(2), 16);
          localObject1 = ((JSONObject)localObject2).getString("data");
          String str = ((String)localObject1).substring(((String)localObject1).indexOf("listid="));
          n = "listid=".length();
          i1 = str.indexOf("&");
          localObject1 = "";
          if (n > 0)
          {
            j = 1;
            break label998;
            if ((k & j) != 0) {
              localObject1 = str.substring(n, i1);
            }
            localSpannableString.setSpan(new rbx(this, paramQQAppInterface, (String)localObject1, paramContext, m | 0xFF000000), 0, localSpannableString.length(), 33);
            localSpannableStringBuilder.append(localSpannableString);
            localStringBuilder.append(((JSONObject)localObject2).getString("text"));
            if (paramString.contains("运气王")) {
              localPasswdRedBagManager.a((String)localObject1);
            }
            break;
          }
          j = 0;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      k = 0;
      continue;
      label936:
      break;
      if (i != paramString.length())
      {
        localSpannableStringBuilder.append(paramString.subSequence(i, paramString.length()));
        localStringBuilder.append(paramString.subSequence(i, paramString.length()));
      }
      this.summary = localStringBuilder.toString();
      return localSpannableStringBuilder;
      label992:
      break;
      continue;
      label998:
      if (n <= i1) {
        k = 1;
      }
    }
  }
  
  public void buildQQWalletTips(QQAppInterface paramQQAppInterface, Context paramContext, TextView paramTextView)
  {
    String str = paramQQAppInterface.a();
    if (str.equals(this.senderUin))
    {
      str = this.senderContent;
      paramQQAppInterface = getQQWalletTips(paramQQAppInterface, paramContext, str);
      if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramQQAppInterface))) {
        break label75;
      }
    }
    label75:
    while (paramTextView == null)
    {
      return;
      if (str.equals(this.reciverUin))
      {
        str = this.reciverContent;
        break;
      }
      str = this.reciverContent;
      break;
    }
    paramTextView.setText(paramQQAppInterface);
    paramTextView.setContentDescription(this.summary);
    paramTextView.setHighlightColor(0);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setGravity(19);
    paramTextView.setPadding(paramTextView.getPaddingLeft(), 6, paramTextView.getPaddingRight(), 6);
    paramTextView.setIncludeFontPadding(true);
    paramTextView.setLineSpacing(0.0F, 1.0F);
  }
  
  /* Error */
  protected void doParse()
  {
    // Byte code:
    //   0: new 318	java/io/ObjectInputStream
    //   3: dup
    //   4: new 320	java/io/ByteArrayInputStream
    //   7: dup
    //   8: aload_0
    //   9: getfield 324	com/tencent/mobileqq/data/MessageForQQWalletTips:msgData	[B
    //   12: invokespecial 327	java/io/ByteArrayInputStream:<init>	([B)V
    //   15: invokespecial 330	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   18: astore_2
    //   19: aload_2
    //   20: astore_1
    //   21: aload_0
    //   22: aload_2
    //   23: invokevirtual 333	java/io/ObjectInputStream:readUTF	()Ljava/lang/String;
    //   26: putfield 264	com/tencent/mobileqq/data/MessageForQQWalletTips:senderUin	Ljava/lang/String;
    //   29: aload_2
    //   30: astore_1
    //   31: aload_0
    //   32: aload_2
    //   33: invokevirtual 333	java/io/ObjectInputStream:readUTF	()Ljava/lang/String;
    //   36: putfield 270	com/tencent/mobileqq/data/MessageForQQWalletTips:reciverUin	Ljava/lang/String;
    //   39: aload_2
    //   40: astore_1
    //   41: aload_0
    //   42: aload_2
    //   43: invokevirtual 333	java/io/ObjectInputStream:readUTF	()Ljava/lang/String;
    //   46: putfield 266	com/tencent/mobileqq/data/MessageForQQWalletTips:senderContent	Ljava/lang/String;
    //   49: aload_2
    //   50: astore_1
    //   51: aload_0
    //   52: aload_2
    //   53: invokevirtual 333	java/io/ObjectInputStream:readUTF	()Ljava/lang/String;
    //   56: putfield 272	com/tencent/mobileqq/data/MessageForQQWalletTips:reciverContent	Ljava/lang/String;
    //   59: aload_2
    //   60: astore_1
    //   61: aload_0
    //   62: aload_2
    //   63: invokevirtual 333	java/io/ObjectInputStream:readUTF	()Ljava/lang/String;
    //   66: putfield 335	com/tencent/mobileqq/data/MessageForQQWalletTips:authKey	Ljava/lang/String;
    //   69: aload_2
    //   70: ifnull +7 -> 77
    //   73: aload_2
    //   74: invokevirtual 338	java/io/ObjectInputStream:close	()V
    //   77: return
    //   78: astore_1
    //   79: aload_1
    //   80: invokevirtual 251	java/lang/Exception:printStackTrace	()V
    //   83: return
    //   84: astore_3
    //   85: aconst_null
    //   86: astore_2
    //   87: aload_2
    //   88: astore_1
    //   89: aload_3
    //   90: invokevirtual 251	java/lang/Exception:printStackTrace	()V
    //   93: aload_2
    //   94: ifnull -17 -> 77
    //   97: aload_2
    //   98: invokevirtual 338	java/io/ObjectInputStream:close	()V
    //   101: return
    //   102: astore_1
    //   103: aload_1
    //   104: invokevirtual 251	java/lang/Exception:printStackTrace	()V
    //   107: return
    //   108: astore_2
    //   109: aconst_null
    //   110: astore_1
    //   111: aload_1
    //   112: ifnull +7 -> 119
    //   115: aload_1
    //   116: invokevirtual 338	java/io/ObjectInputStream:close	()V
    //   119: aload_2
    //   120: athrow
    //   121: astore_1
    //   122: aload_1
    //   123: invokevirtual 251	java/lang/Exception:printStackTrace	()V
    //   126: goto -7 -> 119
    //   129: astore_2
    //   130: goto -19 -> 111
    //   133: astore_3
    //   134: goto -47 -> 87
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	137	0	this	MessageForQQWalletTips
    //   20	41	1	localObjectInputStream1	java.io.ObjectInputStream
    //   78	2	1	localException1	Exception
    //   88	1	1	localObjectInputStream2	java.io.ObjectInputStream
    //   102	2	1	localException2	Exception
    //   110	6	1	localObject1	Object
    //   121	2	1	localException3	Exception
    //   18	80	2	localObjectInputStream3	java.io.ObjectInputStream
    //   108	12	2	localObject2	Object
    //   129	1	2	localObject3	Object
    //   84	6	3	localException4	Exception
    //   133	1	3	localException5	Exception
    // Exception table:
    //   from	to	target	type
    //   73	77	78	java/lang/Exception
    //   0	19	84	java/lang/Exception
    //   97	101	102	java/lang/Exception
    //   0	19	108	finally
    //   115	119	121	java/lang/Exception
    //   21	29	129	finally
    //   31	39	129	finally
    //   41	49	129	finally
    //   51	59	129	finally
    //   61	69	129	finally
    //   89	93	129	finally
    //   21	29	133	java/lang/Exception
    //   31	39	133	java/lang/Exception
    //   41	49	133	java/lang/Exception
    //   51	59	133	java/lang/Exception
    //   61	69	133	java/lang/Exception
  }
  
  public byte[] getBytes()
  {
    prewrite();
    return this.msgData;
  }
  
  /* Error */
  protected void prewrite()
  {
    // Byte code:
    //   0: new 345	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 346	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore 4
    //   9: new 348	java/io/ObjectOutputStream
    //   12: dup
    //   13: aload 4
    //   15: invokespecial 351	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   18: astore_2
    //   19: aload_2
    //   20: astore_1
    //   21: aload_2
    //   22: aload_0
    //   23: getfield 264	com/tencent/mobileqq/data/MessageForQQWalletTips:senderUin	Ljava/lang/String;
    //   26: invokevirtual 354	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
    //   29: aload_2
    //   30: astore_1
    //   31: aload_2
    //   32: aload_0
    //   33: getfield 270	com/tencent/mobileqq/data/MessageForQQWalletTips:reciverUin	Ljava/lang/String;
    //   36: invokevirtual 354	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
    //   39: aload_2
    //   40: astore_1
    //   41: aload_2
    //   42: aload_0
    //   43: getfield 266	com/tencent/mobileqq/data/MessageForQQWalletTips:senderContent	Ljava/lang/String;
    //   46: invokevirtual 354	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
    //   49: aload_2
    //   50: astore_1
    //   51: aload_2
    //   52: aload_0
    //   53: getfield 272	com/tencent/mobileqq/data/MessageForQQWalletTips:reciverContent	Ljava/lang/String;
    //   56: invokevirtual 354	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
    //   59: aload_2
    //   60: astore_1
    //   61: aload_2
    //   62: aload_0
    //   63: getfield 335	com/tencent/mobileqq/data/MessageForQQWalletTips:authKey	Ljava/lang/String;
    //   66: invokevirtual 354	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
    //   69: aload_2
    //   70: astore_1
    //   71: aload_2
    //   72: invokevirtual 355	java/io/ObjectOutputStream:close	()V
    //   75: aload_2
    //   76: astore_1
    //   77: aload_0
    //   78: aload 4
    //   80: invokevirtual 358	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   83: putfield 324	com/tencent/mobileqq/data/MessageForQQWalletTips:msgData	[B
    //   86: aload_2
    //   87: ifnull +7 -> 94
    //   90: aload_2
    //   91: invokevirtual 355	java/io/ObjectOutputStream:close	()V
    //   94: aload 4
    //   96: ifnull +8 -> 104
    //   99: aload 4
    //   101: invokevirtual 359	java/io/ByteArrayOutputStream:close	()V
    //   104: return
    //   105: astore_1
    //   106: aload_1
    //   107: invokevirtual 251	java/lang/Exception:printStackTrace	()V
    //   110: goto -16 -> 94
    //   113: astore_1
    //   114: aload_1
    //   115: invokevirtual 251	java/lang/Exception:printStackTrace	()V
    //   118: return
    //   119: astore_3
    //   120: aconst_null
    //   121: astore_2
    //   122: aload_2
    //   123: astore_1
    //   124: aload_3
    //   125: invokevirtual 251	java/lang/Exception:printStackTrace	()V
    //   128: aload_2
    //   129: ifnull +7 -> 136
    //   132: aload_2
    //   133: invokevirtual 355	java/io/ObjectOutputStream:close	()V
    //   136: aload 4
    //   138: ifnull -34 -> 104
    //   141: aload 4
    //   143: invokevirtual 359	java/io/ByteArrayOutputStream:close	()V
    //   146: return
    //   147: astore_1
    //   148: aload_1
    //   149: invokevirtual 251	java/lang/Exception:printStackTrace	()V
    //   152: return
    //   153: astore_1
    //   154: aload_1
    //   155: invokevirtual 251	java/lang/Exception:printStackTrace	()V
    //   158: goto -22 -> 136
    //   161: astore_2
    //   162: aconst_null
    //   163: astore_1
    //   164: aload_1
    //   165: ifnull +7 -> 172
    //   168: aload_1
    //   169: invokevirtual 355	java/io/ObjectOutputStream:close	()V
    //   172: aload 4
    //   174: ifnull +8 -> 182
    //   177: aload 4
    //   179: invokevirtual 359	java/io/ByteArrayOutputStream:close	()V
    //   182: aload_2
    //   183: athrow
    //   184: astore_1
    //   185: aload_1
    //   186: invokevirtual 251	java/lang/Exception:printStackTrace	()V
    //   189: goto -17 -> 172
    //   192: astore_1
    //   193: aload_1
    //   194: invokevirtual 251	java/lang/Exception:printStackTrace	()V
    //   197: goto -15 -> 182
    //   200: astore_2
    //   201: goto -37 -> 164
    //   204: astore_3
    //   205: goto -83 -> 122
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	208	0	this	MessageForQQWalletTips
    //   20	57	1	localObjectOutputStream1	java.io.ObjectOutputStream
    //   105	2	1	localException1	Exception
    //   113	2	1	localException2	Exception
    //   123	1	1	localObjectOutputStream2	java.io.ObjectOutputStream
    //   147	2	1	localException3	Exception
    //   153	2	1	localException4	Exception
    //   163	6	1	localObject1	Object
    //   184	2	1	localException5	Exception
    //   192	2	1	localException6	Exception
    //   18	115	2	localObjectOutputStream3	java.io.ObjectOutputStream
    //   161	22	2	localObject2	Object
    //   200	1	2	localObject3	Object
    //   119	6	3	localException7	Exception
    //   204	1	3	localException8	Exception
    //   7	171	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   90	94	105	java/lang/Exception
    //   99	104	113	java/lang/Exception
    //   9	19	119	java/lang/Exception
    //   141	146	147	java/lang/Exception
    //   132	136	153	java/lang/Exception
    //   9	19	161	finally
    //   168	172	184	java/lang/Exception
    //   177	182	192	java/lang/Exception
    //   21	29	200	finally
    //   31	39	200	finally
    //   41	49	200	finally
    //   51	59	200	finally
    //   61	69	200	finally
    //   71	75	200	finally
    //   77	86	200	finally
    //   124	128	200	finally
    //   21	29	204	java/lang/Exception
    //   31	39	204	java/lang/Exception
    //   41	49	204	java/lang/Exception
    //   51	59	204	java/lang/Exception
    //   61	69	204	java/lang/Exception
    //   71	75	204	java/lang/Exception
    //   77	86	204	java/lang/Exception
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\MessageForQQWalletTips.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */