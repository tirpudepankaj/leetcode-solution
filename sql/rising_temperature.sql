Select w1.id 
from Weather w1, Weather w2
where w1.temperature > w2.temperature
and TO_DAYS(w1.recordDate) - TO_DAYS(w2.recordDate) = 1;
