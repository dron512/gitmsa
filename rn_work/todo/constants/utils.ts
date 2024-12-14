import dayjs from 'dayjs';

export const fillEmptyColumns = (now:any)=>{

  const start = dayjs(now).startOf('month');
  const end = dayjs(now).endOf('month');

  console.log(start.get('date'), end.get('date'));
  const columns = [];

  for(let i:any=start.get('date'); i<end.get('date'); i++)
  {
    columns.push(start.add(1,'day'))
  }  

  console.log(columns);
}