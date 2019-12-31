 <%@page import="com.jay.dao.Postdao"%>
  <%@page import="com.jay.entity.*" %>
   <%@page import="java.util.*" %>
  <%@page import="com.java.connection_provider.Db_Connection" %>
  
  
  <div class="row">
<%

Postdao pd=new Postdao(Db_Connection.getconnection());
int cid=Integer.parseInt(request.getParameter("cid"));
List<Post> ls=null;
if(cid==0)
{
 ls=pd.getPost();
}
else
{
	ls=pd.getSelectedCategoryPost(cid);
}
if(ls.size()==0)
{
out.println("<h3 class='diapaly-3 text-center'>Sorry...! No any post is in this category</h3>");
return ;	
	
}



for(Post p : ls)
{


%>



 <div class="col-md-6 mt-2">
 
 <div class="card">
  <img class="card-img-top" src="img/defalt.png" alt="Card image cap">
  <div class="card-body">
 
 <b><%=  p.getpTitle() %></b>
 
  <p><%=  p.getpContent() %></p>
   
  </div>
  <div class="card-footer text-center">
   <a href="#!" class="btn btn-outline-primary btn-sm"><i  class="fa fa-thumbs-o-up"><span>10</span></i></a>
    <a href="show_blog.jsp?pid=<%= p.getPid() %>" class="btn btn-outline-primary btn-sm">Read More</a>
   <a href="#!" class="btn  btn-outline-primary btn-sm"><i  class="fa fa-commenting-o"><span>10</span></i>></a>
 
 
  
  
  
  
  </div>
  
  
  </div>
  </div>
  <% ;} %>
  
  </div>