function loadMembers() {
    fetch('/members')
        .then(response => response.json())
        .then(data => {
            const membersDiv = document.getElementById('members');
            membersDiv.innerHTML = '';

            data.forEach(member => {
                membersDiv.innerHTML += `
                    <div class="card">
                        <h3>${member.firstName} ${member.lastName}</h3>
                        <p>Email: ${member.email}</p>
                        <p>Telefon: ${member.phone}</p>
                        <p>Abonament: ${member.membershipType}</p>
                    </div>
                `;
            });
        });
}

function loadTrainers() {
    fetch('/trainers')
        .then(response => response.json())
        .then(data => {
            const trainersDiv = document.getElementById('trainers');
            trainersDiv.innerHTML = '';

            data.forEach(trainer => {
                trainersDiv.innerHTML += `
                    <div class="card">
                        <h3>${trainer.firstName} ${trainer.lastName}</h3>
                        <p>Specializare: ${trainer.specialization}</p>
                        <p>Telefon: ${trainer.phone}</p>
                    </div>
                `;
            });
        });
}

function loadClasses() {
    fetch('/classes')
        .then(response => response.json())
        .then(data => {
            const classesDiv = document.getElementById('classes');
            classesDiv.innerHTML = '';

            data.forEach(fitnessClass => {
                classesDiv.innerHTML += `
                    <div class="card">
                        <h3>${fitnessClass.className}</h3>
                        <p>Program: ${fitnessClass.schedule}</p>
                        <p>Trainer: ${fitnessClass.trainer.firstName} ${fitnessClass.trainer.lastName}</p>
                    </div>
                `;
            });
        });
}

function loadMemberships() {
    fetch('/memberships')
        .then(response => response.json())
        .then(data => {
            const membershipsDiv = document.getElementById('memberships');
            membershipsDiv.innerHTML = '';

            data.forEach(membership => {
                membershipsDiv.innerHTML += `
                    <div class="card">
                        <h3>${membership.member.firstName} ${membership.member.lastName}</h3>
                        <p>Start: ${membership.startDate}</p>
                        <p>End: ${membership.endDate}</p>
                        <p>Pret: ${membership.price} RON</p>
                    </div>
                `;
            });
        });
}

function loadPayments() {
    fetch('/payments')
        .then(response => response.json())
        .then(data => {
            const paymentsDiv = document.getElementById('payments');
            paymentsDiv.innerHTML = '';

            data.forEach(payment => {
                paymentsDiv.innerHTML += `
                    <div class="card">
                        <h3>${payment.member.firstName} ${payment.member.lastName}</h3>
                        <p>Suma: ${payment.amount} RON</p>
                        <p>Data: ${payment.paymentDate}</p>
                    </div>
                `;
            });
        });
}