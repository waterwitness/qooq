import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SearchHistoryManager;
import com.tencent.mobileqq.data.SearchHistory;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class und
  implements Runnable
{
  public und(int paramInt, String paramString1, String paramString2, String paramString3, QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    SearchHistory localSearchHistory = new SearchHistory();
    localSearchHistory.type = this.jdField_a_of_type_Int;
    localSearchHistory.uin = this.jdField_a_of_type_JavaLangString;
    localSearchHistory.troopUin = this.b;
    localSearchHistory.displayName = this.c;
    SearchHistoryManager localSearchHistoryManager = (SearchHistoryManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(54);
    if (localSearchHistoryManager == null) {
      return;
    }
    localSearchHistoryManager.a(localSearchHistory);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\und.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */