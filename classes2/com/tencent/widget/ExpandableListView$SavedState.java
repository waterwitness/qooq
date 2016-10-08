package com.tencent.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View.BaseSavedState;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import xtb;

public class ExpandableListView$SavedState
  extends View.BaseSavedState
{
  public static final Parcelable.Creator CREATOR = new xtb();
  private Parcelable jdField_a_of_type_AndroidOsParcelable;
  ArrayList jdField_a_of_type_JavaUtilArrayList;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private ExpandableListView$SavedState(Parcel paramParcel)
  {
    super(paramParcel);
    this.jdField_a_of_type_AndroidOsParcelable = paramParcel.readParcelable(getClass().getClassLoader());
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    paramParcel.readList(this.jdField_a_of_type_JavaUtilArrayList, ExpandableListConnector.class.getClassLoader());
  }
  
  ExpandableListView$SavedState(Parcelable paramParcelable, ArrayList paramArrayList)
  {
    super(EMPTY_STATE);
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_a_of_type_AndroidOsParcelable = paramParcelable;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeParcelable(this.jdField_a_of_type_AndroidOsParcelable, paramInt);
    paramParcel.writeList(this.jdField_a_of_type_JavaUtilArrayList);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\widget\ExpandableListView$SavedState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */