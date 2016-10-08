package com.tencent.mobileqq.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.uniqueConstraints;

@uniqueConstraints(clause=ConflictClause.IGNORE, columnNames="eId,epId,keyword")
public class EmoticonKeyword
  extends Emoticon
{
  public int _index;
  public boolean valid;
  
  public EmoticonKeyword()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\EmoticonKeyword.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */