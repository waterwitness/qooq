import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qidian.QidianProfileCardActivity.QidianSimpleProfileItem;

public final class wzb
  implements Parcelable.Creator
{
  public wzb()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public QidianProfileCardActivity.QidianSimpleProfileItem a(Parcel paramParcel)
  {
    boolean bool2 = true;
    QidianProfileCardActivity.QidianSimpleProfileItem localQidianSimpleProfileItem = new QidianProfileCardActivity.QidianSimpleProfileItem();
    localQidianSimpleProfileItem.jdField_a_of_type_JavaLangString = paramParcel.readString();
    localQidianSimpleProfileItem.jdField_b_of_type_JavaLangString = paramParcel.readString();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      localQidianSimpleProfileItem.jdField_a_of_type_Boolean = bool1;
      localQidianSimpleProfileItem.jdField_a_of_type_Int = paramParcel.readInt();
      localQidianSimpleProfileItem.jdField_b_of_type_Int = paramParcel.readInt();
      localQidianSimpleProfileItem.jdField_c_of_type_JavaLangString = paramParcel.readString();
      if (paramParcel.readByte() == 0) {
        break label101;
      }
      bool1 = true;
      label74:
      localQidianSimpleProfileItem.jdField_b_of_type_Boolean = bool1;
      if (paramParcel.readByte() == 0) {
        break label106;
      }
    }
    label101:
    label106:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localQidianSimpleProfileItem.jdField_c_of_type_Boolean = bool1;
      return localQidianSimpleProfileItem;
      bool1 = false;
      break;
      bool1 = false;
      break label74;
    }
  }
  
  public QidianProfileCardActivity.QidianSimpleProfileItem[] a(int paramInt)
  {
    return new QidianProfileCardActivity.QidianSimpleProfileItem[paramInt];
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */