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

        <button onclick="deleteMember(${member.id})">Șterge membru</button>
        <button onclick="showEditMemberForm(${member.id}, '${member.firstName}', '${member.lastName}', '${member.phone}', '${member.email}', '${member.membershipType}')">
            Editează membru
        </button>

        <div id="edit-form-${member.id}"></div>
    </div>
`;
            });
        });
}

function addMember() {
    const member = {
        firstName: document.getElementById('firstName').value,
        lastName: document.getElementById('lastName').value,
        phone: document.getElementById('phone').value,
        email: document.getElementById('email').value,
        membershipType: document.getElementById('membershipType').value
    };

    fetch('/members', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(member)
    })
        .then(response => response.json())
        .then(data => {
            alert('Membrul a fost adăugat cu succes!');

            document.getElementById('firstName').value = '';
            document.getElementById('lastName').value = '';
            document.getElementById('phone').value = '';
            document.getElementById('email').value = '';
            document.getElementById('membershipType').value = '';

            loadMembers();
        });
}

function deleteMember(id) {
    fetch('/members/' + id, {
        method: 'DELETE'
    })
        .then(response => response.text())
        .then(data => {
            alert('Membrul a fost șters cu succes!');
            loadMembers();
        });
}

function showEditMemberForm(id, firstName, lastName, phone, email, membershipType) {
    const editDiv = document.getElementById('edit-form-' + id);

    editDiv.innerHTML = `
        <div class="form-card">
            <h3>Editează membru</h3>

            <input type="text" id="editFirstName-${id}" value="${firstName}">
            <input type="text" id="editLastName-${id}" value="${lastName}">
            <input type="text" id="editPhone-${id}" value="${phone}">
            <input type="email" id="editEmail-${id}" value="${email}">
            <input type="text" id="editMembershipType-${id}" value="${membershipType}">

            <button onclick="updateMember(${id})">Salvează modificările</button>
        </div>
    `;
}

function updateMember(id) {
    const updatedMember = {
        firstName: document.getElementById('editFirstName-' + id).value,
        lastName: document.getElementById('editLastName-' + id).value,
        phone: document.getElementById('editPhone-' + id).value,
        email: document.getElementById('editEmail-' + id).value,
        membershipType: document.getElementById('editMembershipType-' + id).value
    };

    fetch('/members/' + id, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(updatedMember)
    })
        .then(response => response.json())
        .then(data => {
            alert('Membrul a fost modificat cu succes!');
            loadMembers();
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

                        <button onclick="deleteTrainer(${trainer.id})">Șterge antrenor</button>
                        <button onclick="showEditTrainerForm(${trainer.id}, '${trainer.firstName}', '${trainer.lastName}', '${trainer.specialization}', '${trainer.phone}')">
                            Editează antrenor
                        </button>

                        <div id="edit-trainer-form-${trainer.id}"></div>
                    </div>
                `;
            });
        });
}

function addTrainer() {
    const trainer = {
        firstName: document.getElementById('trainerFirstName').value,
        lastName: document.getElementById('trainerLastName').value,
        specialization: document.getElementById('trainerSpecialization').value,
        phone: document.getElementById('trainerPhone').value
    };

    fetch('/trainers', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(trainer)
    })
        .then(response => response.json())
        .then(data => {
            alert('Antrenorul a fost adăugat cu succes!');

            document.getElementById('trainerFirstName').value = '';
            document.getElementById('trainerLastName').value = '';
            document.getElementById('trainerSpecialization').value = '';
            document.getElementById('trainerPhone').value = '';

            loadTrainers();
        });
}

function deleteTrainer(id) {
    fetch('/trainers/' + id, {
        method: 'DELETE'
    })
        .then(response => response.text())
        .then(data => {
            alert('Antrenorul a fost șters cu succes!');
            loadTrainers();
        });
}

function showEditTrainerForm(id, firstName, lastName, specialization, phone) {
    const editDiv = document.getElementById('edit-trainer-form-' + id);

    editDiv.innerHTML = `
        <div class="form-card">
            <h3>Editează antrenor</h3>

            <input type="text" id="editTrainerFirstName-${id}" value="${firstName}">
            <input type="text" id="editTrainerLastName-${id}" value="${lastName}">
            <input type="text" id="editTrainerSpecialization-${id}" value="${specialization}">
            <input type="text" id="editTrainerPhone-${id}" value="${phone}">

            <button onclick="updateTrainer(${id})">Salvează modificările</button>
        </div>
    `;
}

function updateTrainer(id) {
    const updatedTrainer = {
        firstName: document.getElementById('editTrainerFirstName-' + id).value,
        lastName: document.getElementById('editTrainerLastName-' + id).value,
        specialization: document.getElementById('editTrainerSpecialization-' + id).value,
        phone: document.getElementById('editTrainerPhone-' + id).value
    };

    fetch('/trainers/' + id, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(updatedTrainer)
    })
        .then(response => response.json())
        .then(data => {
            alert('Antrenorul a fost modificat cu succes!');
            loadTrainers();
        });
}

function loadClasses() {
    fetch('/classes')
        .then(response => response.json())
        .then(data => {
            const classesDiv = document.getElementById('classes');
            classesDiv.innerHTML = '';

            data.forEach(fitnessClass => {
                const trainerName = fitnessClass.trainer
                    ? fitnessClass.trainer.firstName + ' ' + fitnessClass.trainer.lastName
                    : 'Fără trainer';

                const trainerId = fitnessClass.trainer ? fitnessClass.trainer.id : '';

                classesDiv.innerHTML += `
                    <div class="card">
                        <h3>${fitnessClass.className}</h3>
                        <p>Program: ${fitnessClass.schedule}</p>
                        <p>Trainer: ${trainerName}</p>
                        <p>ID Trainer: ${trainerId}</p>

                        <button onclick="deleteClass(${fitnessClass.id})">Șterge clasă</button>
                        <button onclick="showEditClassForm(${fitnessClass.id}, '${fitnessClass.className}', '${fitnessClass.schedule}', '${trainerId}')">
                            Editează clasă
                        </button>

                        <div id="edit-class-form-${fitnessClass.id}"></div>
                    </div>
                `;
            });
        });
}

function addClass() {
    const fitnessClass = {
        className: document.getElementById('className').value,
        schedule: document.getElementById('classSchedule').value,
        trainer: {
            id: document.getElementById('classTrainerId').value
        }
    };

    fetch('/classes', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(fitnessClass)
    })
        .then(response => response.json())
        .then(data => {
            alert('Clasa fitness a fost adăugată cu succes!');

            document.getElementById('className').value = '';
            document.getElementById('classSchedule').value = '';
            document.getElementById('classTrainerId').value = '';

            loadClasses();
        });
}

function deleteClass(id) {
    fetch('/classes/' + id, {
        method: 'DELETE'
    })
        .then(response => response.text())
        .then(data => {
            alert('Clasa fitness a fost ștearsă cu succes!');
            loadClasses();
        });
}

function showEditClassForm(id, className, schedule, trainerId) {
    const editDiv = document.getElementById('edit-class-form-' + id);

    editDiv.innerHTML = `
        <div class="form-card">
            <h3>Editează clasă fitness</h3>

            <input type="text" id="editClassName-${id}" value="${className}">
            <input type="text" id="editClassSchedule-${id}" value="${schedule}">
            <input type="number" id="editClassTrainerId-${id}" value="${trainerId}">

            <button onclick="updateClass(${id})">Salvează modificările</button>
        </div>
    `;
}

function updateClass(id) {
    const updatedClass = {
        className: document.getElementById('editClassName-' + id).value,
        schedule: document.getElementById('editClassSchedule-' + id).value,
        trainer: {
            id: document.getElementById('editClassTrainerId-' + id).value
        }
    };

    fetch('/classes/' + id, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(updatedClass)
    })
        .then(response => response.json())
        .then(data => {
            alert('Clasa fitness a fost modificată cu succes!');
            loadClasses();
        });
}

function loadMemberships() {
    fetch('/memberships')
        .then(response => response.json())
        .then(data => {
            const membershipsDiv = document.getElementById('memberships');
            membershipsDiv.innerHTML = '';

            data.forEach(membership => {
                const memberName = membership.member
                    ? membership.member.firstName + ' ' + membership.member.lastName
                    : 'Fără membru';

                const memberId = membership.member ? membership.member.id : '';

                membershipsDiv.innerHTML += `
                    <div class="card">
                        <h3>${memberName}</h3>
                        <p>Start: ${membership.startDate}</p>
                        <p>End: ${membership.endDate}</p>
                        <p>Preț: ${membership.price} RON</p>
                        <p>ID Membru: ${memberId}</p>

                        <button onclick="deleteMembership(${membership.id})">Șterge abonament</button>
                        <button onclick="showEditMembershipForm(${membership.id}, '${membership.startDate}', '${membership.endDate}', '${membership.price}', '${memberId}')">
                            Editează abonament
                        </button>

                        <div id="edit-membership-form-${membership.id}"></div>
                    </div>
                `;
            });
        });
}

function addMembership() {
    const membership = {
        startDate: document.getElementById('membershipStartDate').value,
        endDate: document.getElementById('membershipEndDate').value,
        price: document.getElementById('membershipPrice').value,
        member: {
            id: document.getElementById('membershipMemberId').value
        }
    };

    fetch('/memberships', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(membership)
    })
        .then(response => response.json())
        .then(data => {
            alert('Abonamentul a fost adăugat cu succes!');

            document.getElementById('membershipStartDate').value = '';
            document.getElementById('membershipEndDate').value = '';
            document.getElementById('membershipPrice').value = '';
            document.getElementById('membershipMemberId').value = '';

            loadMemberships();
        });
}

function deleteMembership(id) {
    fetch('/memberships/' + id, {
        method: 'DELETE'
    })
        .then(response => response.text())
        .then(data => {
            alert('Abonamentul a fost șters cu succes!');
            loadMemberships();
        });
}

function showEditMembershipForm(id, startDate, endDate, price, memberId) {
    const editDiv = document.getElementById('edit-membership-form-' + id);

    editDiv.innerHTML = `
        <div class="form-card">
            <h3>Editează abonament</h3>

            <input type="date" id="editMembershipStartDate-${id}" value="${startDate}">
            <input type="date" id="editMembershipEndDate-${id}" value="${endDate}">
            <input type="number" id="editMembershipPrice-${id}" value="${price}">
            <input type="number" id="editMembershipMemberId-${id}" value="${memberId}">

            <button onclick="updateMembership(${id})">Salvează modificările</button>
        </div>
    `;
}

function updateMembership(id) {
    const updatedMembership = {
        startDate: document.getElementById('editMembershipStartDate-' + id).value,
        endDate: document.getElementById('editMembershipEndDate-' + id).value,
        price: document.getElementById('editMembershipPrice-' + id).value,
        member: {
            id: document.getElementById('editMembershipMemberId-' + id).value
        }
    };

    fetch('/memberships/' + id, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(updatedMembership)
    })
        .then(response => response.json())
        .then(data => {
            alert('Abonamentul a fost modificat cu succes!');
            loadMemberships();
        });
}

function loadPayments() {
    fetch('/payments')
        .then(response => response.json())
        .then(data => {
            const paymentsDiv = document.getElementById('payments');
            paymentsDiv.innerHTML = '';

            data.forEach(payment => {
                const memberName = payment.member
                    ? payment.member.firstName + ' ' + payment.member.lastName
                    : 'Fără membru';

                const memberId = payment.member ? payment.member.id : '';

                paymentsDiv.innerHTML += `
                    <div class="card">
                        <h3>${memberName}</h3>
                        <p>Sumă: ${payment.amount} RON</p>
                        <p>Data plății: ${payment.paymentDate}</p>
                        <p>ID Membru: ${memberId}</p>

                        <button onclick="deletePayment(${payment.id})">Șterge plată</button>
                        <button onclick="showEditPaymentForm(${payment.id}, '${payment.amount}', '${payment.paymentDate}', '${memberId}')">
                            Editează plată
                        </button>

                        <div id="edit-payment-form-${payment.id}"></div>
                    </div>
                `;
            });
        });
}

function addPayment() {
    const payment = {
        amount: document.getElementById('paymentAmount').value,
        paymentDate: document.getElementById('paymentDate').value,
        member: {
            id: document.getElementById('paymentMemberId').value
        }
    };

    fetch('/payments', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(payment)
    })
        .then(response => response.json())
        .then(data => {
            alert('Plata a fost adăugată cu succes!');

            document.getElementById('paymentAmount').value = '';
            document.getElementById('paymentDate').value = '';
            document.getElementById('paymentMemberId').value = '';

            loadPayments();
        });
}

function deletePayment(id) {
    fetch('/payments/' + id, {
        method: 'DELETE'
    })
        .then(response => response.text())
        .then(data => {
            alert('Plata a fost ștearsă cu succes!');
            loadPayments();
        });
}

function showEditPaymentForm(id, amount, paymentDate, memberId) {
    const editDiv = document.getElementById('edit-payment-form-' + id);

    editDiv.innerHTML = `
        <div class="form-card">
            <h3>Editează plată</h3>

            <input type="number" id="editPaymentAmount-${id}" value="${amount}">
            <input type="date" id="editPaymentDate-${id}" value="${paymentDate}">
            <input type="number" id="editPaymentMemberId-${id}" value="${memberId}">

            <button onclick="updatePayment(${id})">Salvează modificările</button>
        </div>
    `;
}

function updatePayment(id) {
    const updatedPayment = {
        amount: document.getElementById('editPaymentAmount-' + id).value,
        paymentDate: document.getElementById('editPaymentDate-' + id).value,
        member: {
            id: document.getElementById('editPaymentMemberId-' + id).value
        }
    };

    fetch('/payments/' + id, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(updatedPayment)
    })
        .then(response => response.json())
        .then(data => {
            alert('Plata a fost modificată cu succes!');
            loadPayments();
        });
}