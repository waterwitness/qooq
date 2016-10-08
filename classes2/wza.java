import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qidian.QidianProfileCardActivity.QidianCompoundProfileItem;

public final class wza
  implements Parcelable.Creator
{
  public wza()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public QidianProfileCardActivity.QidianCompoundProfileItem a(Parcel paramParcel)
  {
    boolean bool2 = true;
    QidianProfileCardActivity.QidianCompoundProfileItem localQidianCompoundProfileItem = new QidianProfileCardActivity.QidianCompoundProfileItem();
    localQidianCompoundProfileItem.jdField_a_of_type_JavaLangString = paramParcel.readString();
    localQidianCompoundProfileItem.jdField_b_of_type_JavaLangString = paramParcel.readString();
    localQidianCompoundProfileItem.c = paramParcel.readString();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      localQidianCompoundProfileItem.jdField_a_of_type_Boolean = bool1;
      localQidianCompoundProfileItem.jdField_d_of_type_Int = paramParcel.readInt();
      if (paramParcel.readByte() == 0) {
        break label95;
      }
    }
    label95:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localQidianCompoundProfileItem.jdField_b_of_type_Boolean = bool1;
      localQidianCompoundProfileItem.jdField_d_of_type_JavaLangString = paramParcel.readString();
      localQidianCompoundProfileItem.e = paramParcel.readString();
      return localQidianCompoundProfileItem;
      bool1 = false;
      break;
    }
  }
  
  public QidianProfileCardActivity.QidianCompoundProfileItem[] a(int paramInt)
  {
    return new QidianProfileCardActivity.QidianCompoundProfileItem[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */