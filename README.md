# AppDatabinding-kotlin

this project is a google courses

Do the following:

/-----------Enable data binding in your build.gradle---------------/
dataBinding {
enabled = true
}

/-----------In MainActivity, create a binding object---------------/
private lateinit var binding: ActivityMainBinding

/-----------n onCreate, use DataBindingUtil to set the content view---------------/
binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

/-----------Use the binding object to replace all calls to findViewById, for example:-------------/
binding.doneButton.setOnClickListener….etc


/-----------Create a data class MyName for the name and nickname---------------/
data class MyName(var name: String = "", var nickname: String = "")

/-----------Add a <data> block to activity_main.xml---------------/
<data>
    <variable
    name="myName"
    type="com.example.android.aboutme.MyName" />
</data>

android:text="@={myName.name}"

/-----------In MainActivity, create an instance of MyName---------------/
private val myName: MyName = MyName("Aleks Haecky")

/-----------And in onCreate(), set binding.myName to it---------------/
binding.myName = myName

/-----------call invalidateAll()t---------------/
In addNickname, set the value of nickname in myName, call invalidateAll(), and the data should show in your views.

myName?.nickname = nicknameEdit.text.toString()
// Invalidate all binding expressions and request a new rebind to refresh UI
invalidateAll()
