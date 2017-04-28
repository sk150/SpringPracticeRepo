# NORMAL VALIDATORS
http://stackoverflow.com/questions/20707485/spring-boot-validation-respond-with-json

[
   {
      "name": "person1 ",
      "age": 20
   },
   {
      "name": "person2",
      "age": 21
   }
]

Content-Type application/json

http://localhost:8080//user/all

<html><script>alert(1);</script></html>

########## TEST-CASES #########
@NotEmpty
String name;

@Min(1)
Integer age; 
TAB RESULT :: []

1) empty json
TAB RESULT :: [REQUEST|RESPONSE(SUMMARY)|RESPONSE RAW=400|]
2) NAME
"name" : 
TAB RESULT :: [REQUEST|RESPONSE(SUMMARY)|RESPONSE RAW]
"abc", 
"",
" ", 
number, 
<SPACE>,  

2) age
"age" : 5, (MIN=1)24, "", abc, " ", <SPACE>

#myth :: response(raw) not become failedafter using @responsebody or @requestbody
if @restcontroller is used then no need for @responsebody
#your json should not have []
#@RequestBody is required with the method param  :: dont know why but without it the code shows name should not be null
#dont forget to add http:// in your url otherwise link will not work 
# [CASE :: SPRINGWEBSERVICESAPP]
what if- in the json processing/accepting method have Person param instead of List<Person> but my json have more than one user info
[OUTPUT] in this case only first value will be cinsidered rest will be discarded
[TRY] List<Person> ???????????

##[ERROR]Request","exception":"org.springframework.http.converter.HttpMessageNotReadableException","message":"Required request body is missing: public org.springframework.http.ResponseEntity<java.lang.Object> com.controller.PersonController.putAllByJson(com.model.Person)","path":"/person/conzume"}
[SOLUTION]change return type of method /conzume as ResponseEntity<Person> or<?>

## [CASE :: SPRINGWEBSERVICESAPP]
 {
      "name": "<script>alert(1);</script>",
      "id": 4
   }

[OUTPUT] 2 ERRORS GET GENERATED

# ALLOWED TAGS OF HTML
According to JavaDoc, allowed tags are:
a, b, blockquote, br, caption, cite, code, col, colgroup, dd, dl, dt, em, h1, h2, h3, h4, h5, h6, i, img, li, ol, p, pre, q, small, strike, strong, sub, sup, table, tbody, td, tfoot, th, thead, tr, u, ul
[NOTE] EVEN YOUT <html> tag need to be allowed through following
@SafeHtml(whitelistType = WhiteListType.RELAXED,
			  additionalTags = {"html","div"})

[TO ALLOW OTHER TAGS OF HTML WE WRITE IT AS]
@SafeHtml(whitelistType = WhiteListType.RELAXED, 
	  additionalTagsWithAttributes = {
	  @Tag(name = "div", attributes = {"class", "style"}),
	  @Tag(name = "anotherTag", attributes = {"id", "anotherAttribute"})})
[REF] https://hibernate.atlassian.net/browse/HV-817?page=com.atlassian.jira.plugin.system.issuetabpanels%3Aall-tabpanel

[CASE]
AFTER IMPLEMENTING "whitelistType" as in above case
check for following cases in "name" field of json
1) PASS :: "name" : "<html></html>"
2) FAIL :: "name" : "<html><script></script></html>"
3) FAIL :: "name" : "<script></script>"




