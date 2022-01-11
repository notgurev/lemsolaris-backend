## Todo

### Общее
- [ ] Конфигурация приложения 

### Отдельные страницы
[Внешние сервисы](external.md)

### Сервисы
- [ ] Генератор маршрутов
  - Знает список аномалий, доступные ресурсы, корабли
  - Из списка аномалий создает маршрут и возвращает
- [ ] Диспетчер полетов 
  - Следит за расписанием полетов и меняет их статус (например, когда полет начался и закончился)
  - Возвращает ресурсы
  - Генерирует события в полете
      - Выбирает результат полета (успешный/провал)
      - Выбирает, какие ресурсы были потрачены (аптечки)
      - Убивает людей и фантомов, уничтожает корабли
  - Активирует создатель отчетов по окончанию полета
- [ ] Создатель отчетов
  - Создает отчет от имени сотрудника
  - По факту генерирует информацию об аномалии

### Генераторы
- [ ] Генератор туристов — рандомно генерирует туристов
- [ ] Генератор кораблей — так как мы забыли про биржу