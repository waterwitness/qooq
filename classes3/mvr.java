import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;

public class mvr
  implements HttpWebCgiAsyncTask.Callback
{
  public mvr(TroopMemberListActivity paramTroopMemberListActivity)
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
    //   25: ifne +162 -> 187
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
    //   71: getfield 12	mvr:a	Lcom/tencent/mobileqq/activity/TroopMemberListActivity;
    //   74: iconst_1
    //   75: aload_0
    //   76: getfield 12	mvr:a	Lcom/tencent/mobileqq/activity/TroopMemberListActivity;
    //   79: ldc 73
    //   81: invokevirtual 79	com/tencent/mobileqq/activity/TroopMemberListActivity:getString	(I)Ljava/lang/String;
    //   84: iconst_0
    //   85: invokestatic 84	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;ILjava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   88: aload_0
    //   89: getfield 12	mvr:a	Lcom/tencent/mobileqq/activity/TroopMemberListActivity;
    //   92: invokevirtual 88	com/tencent/mobileqq/activity/TroopMemberListActivity:getTitleBarHeight	()I
    //   95: invokevirtual 92	com/tencent/mobileqq/widget/QQToast:b	(I)Landroid/widget/Toast;
    //   98: pop
    //   99: aload_0
    //   100: getfield 12	mvr:a	Lcom/tencent/mobileqq/activity/TroopMemberListActivity;
    //   103: getfield 96	com/tencent/mobileqq/activity/TroopMemberListActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
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
    //   130: getfield 12	mvr:a	Lcom/tencent/mobileqq/activity/TroopMemberListActivity;
    //   133: getfield 96	com/tencent/mobileqq/activity/TroopMemberListActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   136: bipush 51
    //   138: invokevirtual 113	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   141: checkcast 115	com/tencent/mobileqq/app/TroopManager
    //   144: astore_1
    //   145: aload_1
    //   146: ifnull +41 -> 187
    //   149: aload_1
    //   150: aload_0
    //   151: getfield 12	mvr:a	Lcom/tencent/mobileqq/activity/TroopMemberListActivity;
    //   154: getfield 119	com/tencent/mobileqq/activity/TroopMemberListActivity:k	Ljava/lang/String;
    //   157: invokevirtual 122	com/tencent/mobileqq/app/TroopManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/TroopInfo;
    //   160: astore_3
    //   161: aload_3
    //   162: ifnull +25 -> 187
    //   165: aload_3
    //   166: getfield 128	com/tencent/mobileqq/data/TroopInfo:dwOfficeMode	J
    //   169: lconst_1
    //   170: lcmp
    //   171: ifne +17 -> 188
    //   174: iconst_0
    //   175: istore_2
    //   176: aload_3
    //   177: iload_2
    //   178: i2l
    //   179: putfield 128	com/tencent/mobileqq/data/TroopInfo:dwOfficeMode	J
    //   182: aload_1
    //   183: aload_3
    //   184: invokevirtual 131	com/tencent/mobileqq/app/TroopManager:b	(Lcom/tencent/mobileqq/data/TroopInfo;)V
    //   187: return
    //   188: iconst_1
    //   189: istore_2
    //   190: goto -14 -> 176
    //   193: astore_1
    //   194: aload_1
    //   195: invokevirtual 134	org/json/JSONException:printStackTrace	()V
    //   198: return
    //   199: astore_1
    //   200: aload_1
    //   201: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	202	0	this	mvr
    //   0	202	1	paramJSONObject	org.json.JSONObject
    //   0	202	2	paramInt	int
    //   0	202	3	paramBundle	android.os.Bundle
    //   1	23	4	i	int
    //   13	3	5	j	int
    // Exception table:
    //   from	to	target	type
    //   7	15	193	org/json/JSONException
    //   7	15	199	finally
    //   194	198	199	finally
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mvr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */