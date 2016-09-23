
import main.models.Todo;

@Path("/users/{id}/todos/{todo}")	  
public class JerseyREST 
{
	  @GET 
	  public Response getTodo(@PathParam("id") String id, @PathParam("todo") String todoId) 
	  {
		  // "Fetch 'TODO' from DB"
		  Todo todo = new Todo();
		  todo.id = todoId;
		  todo.description = "todo from user " + id;
		  todo.summary = "remember the milk";
		  String json = new Gson().toJson(todo);
		  return Response.ok(json, MediaType.APPLICATION_JSON).build();
	  }

	 @POST
	  @Produces(MediaType.TEXT_HTML)
	  @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	  public void newTodo(@FormParam("id") String id,
	      @FormParam("summary") String summary,
	      @FormParam("description") String description,
	      @Context HttpServletResponse servletResponse) throws IOException {

	    servletResponse.sendRedirect("/");
	  }
	 
}
