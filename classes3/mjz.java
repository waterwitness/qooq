import android.os.Parcelable.Creator;
import com.tencent.mobileqq.activity.SearchTroopListActivity.StrangeTroopWrapper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class mjz
  implements Parcelable.Creator
{
  public mjz()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  /* Error */
  public SearchTroopListActivity.StrangeTroopWrapper a(android.os.Parcel paramParcel)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 27	android/os/Parcel:readInt	()I
    //   4: newarray <illegal type>
    //   6: astore_2
    //   7: aload_1
    //   8: aload_2
    //   9: invokevirtual 31	android/os/Parcel:readByteArray	([B)V
    //   12: new 33	tencent/im/kqq/searchgroup/SearchGroup$GroupInfo
    //   15: dup
    //   16: invokespecial 34	tencent/im/kqq/searchgroup/SearchGroup$GroupInfo:<init>	()V
    //   19: astore_1
    //   20: aload_1
    //   21: aload_2
    //   22: invokevirtual 38	tencent/im/kqq/searchgroup/SearchGroup$GroupInfo:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   25: pop
    //   26: new 40	com/tencent/mobileqq/activity/SearchTroopListActivity$StrangeTroopWrapper
    //   29: dup
    //   30: aload_1
    //   31: invokespecial 43	com/tencent/mobileqq/activity/SearchTroopListActivity$StrangeTroopWrapper:<init>	(Ltencent/im/kqq/searchgroup/SearchGroup$GroupInfo;)V
    //   34: areturn
    //   35: astore_1
    //   36: aconst_null
    //   37: astore_1
    //   38: goto -12 -> 26
    //   41: astore_2
    //   42: goto -16 -> 26
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	45	0	this	mjz
    //   0	45	1	paramParcel	android.os.Parcel
    //   6	16	2	arrayOfByte	byte[]
    //   41	1	2	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   12	20	35	java/lang/Exception
    //   20	26	41	java/lang/Exception
  }
  
  public SearchTroopListActivity.StrangeTroopWrapper[] a(int paramInt)
  {
    return new SearchTroopListActivity.StrangeTroopWrapper[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mjz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */