package sample;

import org.seasar.doma.jdbc.criteria.Entityql;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/hello")
public class MessageResource {

  private final MessageDao messageDao;
  private final Entityql config;

  public MessageResource(MessageDao messageDao, Entityql config) {
    this.messageDao = messageDao;
    this.config = config;
  }

  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String hello() {
    List<Message> messages = messageDao.selectByLocale(new Locale("en", "US"));
    return messages.stream().findFirst().map(m -> m.text.getValue()).orElseGet(() -> "empty");
  }

  @GET
  @Produces(MediaType.TEXT_PLAIN)
  @Path("/{id}")
  public String hello(@PathParam("id") int id) throws Exception {
    Message message = messageDao.selectById(id);
    return message == null ? "empty" : message.text.getValue();
  }
}
