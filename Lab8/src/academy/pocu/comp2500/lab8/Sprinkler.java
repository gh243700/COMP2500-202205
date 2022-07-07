package academy.pocu.comp2500.lab8;

import java.util.ArrayList;
public class Sprinkler extends SmartDevice implements ISprayable{
    private static final int SPRAY_AMOUNT = 15;
    private ArrayList<Schedule> schedules = new ArrayList<>();
    private int schedules_index;
    private int tickCount;
    private Schedule scheduleOrNull;

    public void addSchedule(Schedule schedule) {
        schedules.add(schedule);
    }

    @Override
    public void onTick() {
        tick++;
        if (scheduleOrNull == null) {
            for (int i = schedules_index; i < schedules.size(); i++) {
                Schedule s = schedules.get(i);
                if (tick <= s.getTickAt() + s.getTickTill() && s.getTickAt() != 0) {
                    scheduleOrNull = s;
                    onAt = tick - 1;
                    schedules_index = i;
                    if (tick <= s.getTickAt()) {
                        scheduleOrNull.setValid(true);
                    } else {
                        tickCount = tick - scheduleOrNull.getTickAt() - 1;
                    }
                    break;
                }
            }


            if (schedules_index >= schedules.size() || scheduleOrNull == null) {
                if (isOn == true) {
                    onAt = tick;
                    isOn = false;
                }
                return;
            }

        }

        if (tick >= scheduleOrNull.getTickAt()  && scheduleOrNull.isValid() && tickCount <= scheduleOrNull.getTickTill()) {
            tickCount++;
            if (isOn == false) {
                onAt = tick;
                isOn = true;
            }
        } else {
            if (scheduleOrNull.isValid() == false) {
                tickCount++;
            }
            if (isOn == true) {
                onAt = tick;
                isOn = false;
            }
        }

        if (tickCount == scheduleOrNull.getTickTill()) {
            scheduleOrNull = null;
            tickCount = 0;
            schedules_index++;
        }
    }

    @Override
    public void install(Planter planter) {
        planter.installSprinkler(this);
    }

    @Override
    public void spray(Planter planter) {
        if (isOn == true) {
            planter.addWaterAmount(SPRAY_AMOUNT);
        }
    }
}
