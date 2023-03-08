

Controller: 

@RestController
@RequestMapping("/api/v1/userstories")
public class UserStoryController {

    private final UserStoryService userStoryService;

    @Autowired
    public UserStoryController(UserStoryService userStoryService) {
        this.userStoryService = userStoryService;
    }

    @GetMapping
    public ResponseEntity<?> getUserStories() {
        return ResponseEntity.ok(userStoryService.getUserStories());
    }

    @GetMapping("/{userStoryId}")
    public ResponseEntity<?> getUserStory(@PathVariable Long userStoryId) {
        return ResponseEntity.ok(userStoryService.getUserStory(userStoryId));
    }

}

Service: 

@Service
public class UserStoryService {

    private final UserStoryRepository userStoryRepository;

    @Autowired
    public UserStoryService(UserStoryRepository userStoryRepository) {
        this.userStoryRepository = userStoryRepository;
    }

    public List<UserStory> getUserStories() {
        return userStoryRepository.findAll();
    }

    public UserStory getUserStory(Long userStoryId) {
        return userStoryRepository.findById(userStoryId).orElse(null);
    }

}

Repository:

@Repository
public interface UserStoryRepository extends JpaRepository<UserStory, Long> {

}