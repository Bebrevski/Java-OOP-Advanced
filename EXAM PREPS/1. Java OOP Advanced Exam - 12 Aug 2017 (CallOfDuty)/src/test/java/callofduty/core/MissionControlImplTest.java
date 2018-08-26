package callofduty.core;

import callofduty.interfaces.Mission;
import callofduty.interfaces.MissionControl;
import callofduty.domain.missions.EscortMission;
import callofduty.domain.missions.HuntMission;
import callofduty.domain.missions.SurveillanceMission;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;

public class MissionControlImplTest {

    private static final Integer MISSION_ID_MAXIMUM_LENGTH = 8;

    private static final Double MISSION_RATING_MINIMUM_VALUE = 0D;

    private static final Double MISSION_RATING_MAXIMUM_VALUE = 100D;

    private static final Double MISSION_BOUNTY_MINIMUM_VALUE = 0D;

    private static final Double MISSION_BOUNTY_MAXIMUM_VALUE = 100000D;

    private MissionControl missionControl;

//    @Rule
//    public final ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp() {
        this.missionControl = new MissionControlImpl();
    }

    //TEST 1, 7 and 8
    @Test
    public void generateMission() {
        String id = "1";
        Double rating = 10D;
        Double bounty = 1000D;

        Mission mission = this.missionControl.generateMission(id, rating, bounty);

        Assert.assertTrue(mission instanceof EscortMission);
        Assert.assertEquals(id, mission.getId());
        Assert.assertEquals(rating * 0.75, mission.getRating(), 0.001);
        Assert.assertEquals(bounty * 1.25, mission.getBounty(), 0.001);


        id = "2";
        rating = 10D;
        bounty = 1000D;
        mission = this.missionControl.generateMission(id, rating, bounty);

        Assert.assertTrue(mission instanceof HuntMission);
        Assert.assertEquals(id, mission.getId());
        Assert.assertEquals(rating * 1.5, mission.getRating(), 0.001);
        Assert.assertEquals(bounty * 2, mission.getBounty(), 0.001);

        id = "3";
        rating = 10D;
        bounty = 1000D;
        mission = this.missionControl.generateMission(id, rating, bounty);

        Assert.assertTrue(mission instanceof SurveillanceMission);
        Assert.assertEquals(id, mission.getId());
        Assert.assertEquals(rating * 0.25, mission.getRating(), 0.001);
        Assert.assertEquals(bounty * 1.5, mission.getBounty(), 0.001);

        id = "4";
        rating = 10D;
        bounty = 1000D;
        mission = this.missionControl.generateMission(id, rating, bounty);

        Assert.assertTrue(mission instanceof EscortMission);
        Assert.assertEquals(id, mission.getId());
        Assert.assertEquals(rating * 0.75, mission.getRating(), 0.001);
        Assert.assertEquals(bounty * 1.25, mission.getBounty(), 0.001);
    }

    //TEST 2
    @Test
    public void testId() throws Exception {
        Double rating = 10D;
        Double bounty = 101D;

        Mission mission = this.missionControl.generateMission("XXXXXXXXXXXX", rating, bounty);

        Assert.assertEquals("XXXXXXXX", mission.getId());
    }

    //TESTS 3 and 4
    @Test
    public void checkAndReformMissionRating() throws Exception {
        Method method = this.missionControl.getClass().getDeclaredMethod("checkAndReformMissionRating", Double.class);
        method.setAccessible(true);

        Double expected = 20D;
        Double actual = (Double) method.invoke(this.missionControl, 20D);
        Assert.assertEquals(expected, actual, 0.00001);

        expected = 0D;
        actual = (Double) method.invoke(this.missionControl, -44D);
        Assert.assertEquals(expected, actual, 0.00001);

        expected = 100D;
        actual = (Double) method.invoke(this.missionControl, 101D);
        Assert.assertEquals(expected, actual, 0.00001);
    }

    //TESTS 5 and 6
    @Test
    public void checkAndreformMissionBounty() throws Exception {
        Method checkAndReformMissionRatingMethod = this.missionControl.getClass().getDeclaredMethod("checkAndreformMissionBounty", Double.class);
        checkAndReformMissionRatingMethod.setAccessible(true);

        Double actual = (Double) checkAndReformMissionRatingMethod.invoke(this.missionControl, 20D);
        Assert.assertEquals(20, actual, 0.1);

        actual = (Double) checkAndReformMissionRatingMethod.invoke(this.missionControl, -20D);
        Assert.assertEquals(0, actual, 0.1);

        actual = (Double) checkAndReformMissionRatingMethod.invoke(this.missionControl, 120000D);
        Assert.assertEquals(MISSION_BOUNTY_MAXIMUM_VALUE, actual, 0.1);
    }

    //NO REFERENCE TO THE PROBLEM
    @Test
    public void updateMissionType() throws Exception{
        Method updateMissionType = this.missionControl.getClass().getDeclaredMethod("updateMissionType");
        updateMissionType.setAccessible(true);

        Method instantiateMissionObject = this.missionControl.getClass().getDeclaredMethod("currentMission");
        instantiateMissionObject.setAccessible(true);

        instantiateMissionObject.invoke(this.missionControl);
        instantiateMissionObject.invoke(this.missionControl);
        updateMissionType.invoke(this.missionControl);

        Assert.assertEquals(Class.forName("callofduty.domain.missions.EscortMission"), instantiateMissionObject.invoke(this.missionControl));

    }

    //NO REFERENCE TO THE PROBLEM
    @Test
    public void currentMissionField() throws Exception {
        Method instantiateMissionObject = this.missionControl.getClass().getDeclaredMethod("currentMission");
        instantiateMissionObject.setAccessible(true);

        Assert.assertEquals(Class.forName("callofduty.domain.missions.EscortMission"), instantiateMissionObject.invoke(this.missionControl));
        Assert.assertEquals(Class.forName("callofduty.domain.missions.HuntMission"), instantiateMissionObject.invoke(this.missionControl));
        Assert.assertEquals(Class.forName("callofduty.domain.missions.SurveillanceMission"), instantiateMissionObject.invoke(this.missionControl));
    }

    //NO REFERENCE TO THE PROBLEM
    @Test
    public void testIterator() throws Exception {
        Field iteratorField = this.missionControl.getClass().getDeclaredField("missionIterator");
        iteratorField.setAccessible(true);

        Iterator<Map.Entry<String, Class>> iterator = (Iterator<Map.Entry<String, Class>>) iteratorField.get(this.missionControl);

        String[] arr = new String[]{"EscortMission", "HuntMission", "SurveillanceMission"};
        Class[] classes = new Class[]{
                Class.forName("callofduty.domain.missions.EscortMission"),
                Class.forName("callofduty.domain.missions.HuntMission"),
                Class.forName("callofduty.domain.missions.SurveillanceMission")
        };

        int index = 0;
        while (iterator.hasNext()) {
            Map.Entry<String, Class> next = iterator.next();

            Assert.assertEquals(arr[index], next.getKey());
            Assert.assertEquals(classes[index], next.getValue());

            index++;
        }
    }

    //NO REFERENCE TO THE PROBLEM
    @Test
    public void testConstants() throws Exception {
        Field mission_id_max_length = this.missionControl.getClass().getDeclaredField("MISSION_ID_MAXIMUM_LENGTH");
        Field mission_rating_min_value = this.missionControl.getClass().getDeclaredField("MISSION_RATING_MINIMUM_VALUE");
        Field mission_rating_max_value = this.missionControl.getClass().getDeclaredField("MISSION_RATING_MAXIMUM_VALUE");
        Field mission_bounty_min_value = this.missionControl.getClass().getDeclaredField("MISSION_BOUNTY_MINIMUM_VALUE");
        Field mission_bounty_max_value = this.missionControl.getClass().getDeclaredField("MISSION_BOUNTY_MAXIMUM_VALUE");

        mission_id_max_length.setAccessible(true);
        mission_rating_min_value.setAccessible(true);
        mission_rating_max_value.setAccessible(true);
        mission_bounty_min_value.setAccessible(true);
        mission_bounty_max_value.setAccessible(true);

        Assert.assertEquals(MISSION_ID_MAXIMUM_LENGTH, mission_id_max_length.get(this.missionControl));
        Assert.assertEquals(MISSION_RATING_MINIMUM_VALUE, mission_rating_min_value.get(this.missionControl));
        Assert.assertEquals(MISSION_RATING_MAXIMUM_VALUE, mission_rating_max_value.get(this.missionControl));
        Assert.assertEquals(MISSION_BOUNTY_MINIMUM_VALUE, mission_bounty_min_value.get(this.missionControl));
        Assert.assertEquals(MISSION_BOUNTY_MAXIMUM_VALUE, mission_bounty_max_value.get(this.missionControl));
    }

    //NO REFERENCE TO THE PROBLEM
    @Test
    public void checkDefaultMissionClasses() throws Exception {
        Field map = this.missionControl.getClass().getDeclaredField("missionClasses");
        map.setAccessible(true);
        Map<String, Class> missionDefaultClasses = (Map<String, Class>) map.get(this.missionControl);

        Class<?> expectEscort = Class.forName("callofduty.domain.missions.EscortMission");
        Class<?> expectHunt = Class.forName("callofduty.domain.missions.HuntMission");
        Class<?> expectSurveillance = Class.forName("callofduty.domain.missions.SurveillanceMission");

        Assert.assertEquals(expectEscort, missionDefaultClasses.get("EscortMission"));
        Assert.assertEquals(expectHunt, missionDefaultClasses.get("HuntMission"));
        Assert.assertEquals(expectSurveillance, missionDefaultClasses.get("SurveillanceMission"));
    }

    @Test
    public void instantiateMissionObject() throws Exception {
        Method instantiateMissionObject = this.missionControl.getClass().getDeclaredMethod("instantiateMissionObject",
                String.class, Double.class, Double.class);

        instantiateMissionObject.setAccessible(true);

        Mission mission = (Mission) instantiateMissionObject.invoke(this.missionControl, "Nema", 1D, 20D);

        Assert.assertTrue(mission instanceof EscortMission);
        Assert.assertEquals(mission.getId(), "Nema");
        Assert.assertEquals(0.75, mission.getRating(), 0.1);
        Assert.assertEquals(25.0, mission.getBounty(), 0.1);
    }
}