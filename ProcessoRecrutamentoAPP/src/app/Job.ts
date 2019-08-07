import { Task } from './Task';

export class Job {
    id: string;
    name: string;
    active: boolean;
    parentJob = new ParentJob();
    tasks: Task[];
}

export class ParentJob {
    id: string;
}
