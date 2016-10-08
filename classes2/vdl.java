import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.activity.ContactsTroopActivity;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;

public class vdl
  implements HttpWebCgiAsyncTask.Callback
{
  public vdl(ContactsTroopActivity paramContactsTroopActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  /* Error */
  public void a(org.json.JSONObject paramJSONObject, int paramInt, android.os.Bundle paramBundle)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 4
    //   3: aload_1
    //   4: ifnull +16 -> 20
    //   7: aload_1
    //   8: ldc 27
    //   10: invokevirtual 33	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   13: istore 5
    //   15: iload 5
    //   17: ifeq +6 -> 23
    //   20: iconst_0
    //   21: istore 4
    //   23: iload 4
    //   25: ifne +192 -> 217
    //   28: invokestatic 39	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   31: ifeq +39 -> 70
    //   34: ldc 41
    //   36: iconst_2
    //   37: new 43	java/lang/StringBuilder
    //   40: dup
    //   41: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   44: ldc 46
    //   46: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: iload_2
    //   50: invokevirtual 53	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   53: ldc 55
    //   55: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: invokestatic 61	java/lang/System:currentTimeMillis	()J
    //   61: invokevirtual 64	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   64: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: invokestatic 72	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   70: aload_0
    //   71: getfield 12	vdl:a	Lcom/tencent/mobileqq/troop/activity/ContactsTroopActivity;
    //   74: iconst_1
    //   75: aload_0
    //   76: getfield 12	vdl:a	Lcom/tencent/mobileqq/troop/activity/ContactsTroopActivity;
    //   79: ldc 73
    //   81: invokevirtual 79	com/tencent/mobileqq/troop/activity/ContactsTroopActivity:getString	(I)Ljava/lang/String;
    //   84: iconst_0
    //   85: invokestatic 84	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;ILjava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   88: aload_0
    //   89: getfield 12	vdl:a	Lcom/tencent/mobileqq/troop/activity/ContactsTroopActivity;
    //   92: invokevirtual 88	com/tencent/mobileqq/troop/activity/ContactsTroopActivity:getTitleBarHeight	()I
    //   95: invokevirtual 92	com/tencent/mobileqq/widget/QQToast:b	(I)Landroid/widget/Toast;
    //   98: pop
    //   99: aload_0
    //   100: getfield 12	vdl:a	Lcom/tencent/mobileqq/troop/activity/ContactsTroopActivity;
    //   103: getfield 96	com/tencent/mobileqq/troop/activity/ContactsTroopActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   106: ldc 98
    //   108: ldc 100
    //   110: ldc 100
    //   112: ldc 102
    //   114: ldc 102
    //   116: iconst_0
    //   117: iconst_0
    //   118: ldc 100
    //   120: ldc 100
    //   122: ldc 100
    //   124: ldc 100
    //   126: invokestatic 107	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   129: aload_0
    //   130: getfield 12	vdl:a	Lcom/tencent/mobileqq/troop/activity/ContactsTroopActivity;
    //   133: getfield 96	com/tencent/mobileqq/troop/activity/ContactsTroopActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   136: bipush 51
    //   138: invokevirtual 113	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   141: checkcast 115	com/tencent/mobileqq/app/TroopManager
    //   144: astore_1
    //   145: aload_1
    //   146: ifnull +71 -> 217
    //   149: aload_1
    //   150: aload_3
    //   151: ldc 117
    //   153: invokevirtual 122	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   156: invokevirtual 125	com/tencent/mobileqq/app/TroopManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/TroopInfo;
    //   159: astore_3
    //   160: aload_3
    //   161: ifnull +56 -> 217
    //   164: aload_3
    //   165: getfield 131	com/tencent/mobileqq/data/TroopInfo:dwOfficeMode	J
    //   168: lconst_1
    //   169: lcmp
    //   170: ifne +48 -> 218
    //   173: iconst_0
    //   174: istore_2
    //   175: aload_3
    //   176: iload_2
    //   177: i2l
    //   178: putfield 131	com/tencent/mobileqq/data/TroopInfo:dwOfficeMode	J
    //   181: aload_1
    //   182: aload_3
    //   183: invokevirtual 134	com/tencent/mobileqq/app/TroopManager:b	(Lcom/tencent/mobileqq/data/TroopInfo;)V
    //   186: aload_0
    //   187: getfield 12	vdl:a	Lcom/tencent/mobileqq/troop/activity/ContactsTroopActivity;
    //   190: getfield 137	com/tencent/mobileqq/troop/activity/ContactsTroopActivity:a	Lcom/tencent/mobileqq/adapter/TroopListAdapterOfContactsMode;
    //   193: ifnull +17 -> 210
    //   196: aload_0
    //   197: getfield 12	vdl:a	Lcom/tencent/mobileqq/troop/activity/ContactsTroopActivity;
    //   200: getfield 137	com/tencent/mobileqq/troop/activity/ContactsTroopActivity:a	Lcom/tencent/mobileqq/adapter/TroopListAdapterOfContactsMode;
    //   203: aload_3
    //   204: getfield 141	com/tencent/mobileqq/data/TroopInfo:troopuin	Ljava/lang/String;
    //   207: invokevirtual 146	com/tencent/mobileqq/adapter/TroopListAdapterOfContactsMode:b	(Ljava/lang/String;)V
    //   210: aload_0
    //   211: getfield 12	vdl:a	Lcom/tencent/mobileqq/troop/activity/ContactsTroopActivity;
    //   214: invokevirtual 148	com/tencent/mobileqq/troop/activity/ContactsTroopActivity:b	()V
    //   217: return
    //   218: iconst_1
    //   219: istore_2
    //   220: goto -45 -> 175
    //   223: astore_1
    //   224: aload_1
    //   225: invokevirtual 151	org/json/JSONException:printStackTrace	()V
    //   228: return
    //   229: astore_1
    //   230: aload_1
    //   231: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	232	0	this	vdl
    //   0	232	1	paramJSONObject	org.json.JSONObject
    //   0	232	2	paramInt	int
    //   0	232	3	paramBundle	android.os.Bundle
    //   1	23	4	i	int
    //   13	3	5	j	int
    // Exception table:
    //   from	to	target	type
    //   7	15	223	org/json/JSONException
    //   7	15	229	finally
    //   224	228	229	finally
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vdl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */